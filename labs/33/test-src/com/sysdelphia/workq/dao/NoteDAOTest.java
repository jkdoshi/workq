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

	public void testFindById() {
		NoteDAO dao = (NoteDAO) factory.getBean("noteDAO");
		Note note = dao.findById(2);
		assertEquals(Long.valueOf(2), note.getId());
		System.out.println("Note: " + note);
	}

	public void testSave() {
		NoteDAO dao = (NoteDAO) factory.getBean("noteDAO");
		Note note = new Note();
		note.setCreator("me");
		note.setCategory(1);
		note.setBody("This is the note body. Get it?");
		dao.save(note);
		assertNotNull(note.getId());
		System.out.println("Note: " + note);
	}
}
