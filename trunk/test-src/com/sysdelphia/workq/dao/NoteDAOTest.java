package com.sysdelphia.workq.dao;

import java.util.List;

import com.sysdelphia.workq.domain.Note;
import com.sysdelphia.workq.test.SpringTest;

public class NoteDAOTest extends SpringTest {
	public void testFindAll() {
		NoteDAO dao = (NoteDAO) factory.getBean("noteDAO");
		List<Note> list = dao.findAll();
		assertEquals(15, list.size());
		for (Note note : list) {
			System.out.println("Note: " + note);
		}
	}

	public void testFindByCategory() {
		NoteDAO dao = (NoteDAO) factory.getBean("noteDAO");
		List<Note> list = dao.findByCategory(2);
		assertEquals(6, list.size());
		for (Note note : list) {
			System.out.println("Note: " + note);
		}
	}
}
