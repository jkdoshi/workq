package com.sysdelphia.workq.backing;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.apache.myfaces.custom.tree2.TreeModel;
import org.apache.myfaces.custom.tree2.TreeModelBase;
import org.apache.myfaces.custom.tree2.TreeNode;
import org.apache.myfaces.custom.tree2.TreeNodeBase;

import com.sysdelphia.workq.dao.CategoryDAO;
import com.sysdelphia.workq.domain.Category;
import com.sysdelphia.workq.domain.Note;

public class CategoryAction {
	private TreeModel treeModel;

	private List<Category> rows;

	private static class RootNode extends TreeNodeBase {
		private static final long serialVersionUID = 3578889403700000824L;
		private List<CategoryNode> children;

		public RootNode(List<Category> rows) {
			super("root", "root", false);
			this.children = new ArrayList<CategoryNode>(rows.size());
			for (Category row : rows) {
				children.add(new CategoryNode(row));
			}
		}

		@Override
		public List getChildren() {
			return children;
		}
	}

	private static class CategoryNode extends TreeNodeBase {
		private static final long serialVersionUID = 108860868612313363L;

		private Category category;

		private List<NoteNode> children;

		public CategoryNode(Category category) {
			super("category", category.getName(), false);
			this.category = category;
		}

		@Override
		public List getChildren() {
			if (children == null) {
				try {
					List<Note> notes = category.getNotes();
					children = new ArrayList<NoteNode>(notes.size());
					for (Note note : notes) {
						children.add(new NoteNode(note));
					}
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
			return children;
		}

		@Override
		public String getIdentifier() {
			return String.valueOf(category.getId());
		}
	}

	private static class NoteNode extends TreeNodeBase {
		private static final long serialVersionUID = 2427051385778952481L;

		private Note note;

		public NoteNode(Note note) {
			super("note", String.valueOf(note.getId()), true);
			this.note = note;
		}

		@Override
		public String getIdentifier() {
			return String.valueOf(note.getId());
		}
	}

	public String fetchRows() throws SQLException, NamingException {
		rows = new CategoryDAO().findAll();
		treeModel = new TreeModelBase(new RootNode(rows));
		return "";
	}

	public List<Category> getRows() {
		return rows;
	}

	public static TreeNode getCategoryNode(Category category) {
		return new CategoryNode(category);
	}

	public TreeModel getTreeModel() {
		return treeModel;
	}
}
