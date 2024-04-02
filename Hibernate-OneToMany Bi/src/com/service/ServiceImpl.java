package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Student;
import com.model.Subject;
import com.util.HibernateUtil;

public class ServiceImpl implements Services {

	SessionFactory sf = HibernateUtil.getFactory();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addStudentWithSubjects() {

		Session session = sf.openSession();

		Student s = new Student();

		System.out.println("Enter sname : ");
		s.setSname(sc.next());

		System.out.println("Enter How many subjects you want to add : ");
		int n = sc.nextInt();

		List<Subject> list = new ArrayList<Subject>();

		for (int i = 1; i <= n; i++) {

			Subject sub = new Subject();

			System.out.println("Enter subject name : ");
			sub.setSubname(sc.next());

			sub.setStudent(s);

			list.add(sub);

		}

		s.setList(list);
		session.beginTransaction().commit();

	}

	@Override
	public void getStudentWithSubjects() {

		Session session = sf.openSession();
		System.out.println("Enter Stuid : ");
		Student s = session.get(Student.class, sc.nextInt());

		if (s != null) {
			System.out.println(s);
		} else {
			System.out.println("Invalid Id");
		}

	}

	@Override
	public void deleteStudentWithSubjects() {
		Session session = sf.openSession();
		System.out.println("Enter Stuid : ");
		Student s = session.get(Student.class, sc.nextInt());

		if (s != null) {
			session.delete(s);
			session.beginTransaction().commit();
		} else {
			System.out.println("Invalid Id");
		}
	}

	@Override
	public void deleteSubjectOnly() {

		Session session = sf.openSession();
		System.out.println("Enter Stuid : ");
		Student s = session.get(Student.class, sc.nextInt());

		if (s != null) {

			List<Subject> list = s.getList();

			System.out.println("Enter Subject id : ");
			int subId = sc.nextInt();

			Subject subject = null;

			for (Subject sub : list) {

				if (sub.getSubid() == subId) {
					subject = sub;
				}

			}

			list.remove(subject);
			subject.setStudent(null);

			session.delete(subject);
			session.beginTransaction().commit();

		} else {
			System.out.println("Invalid Id");
		}

	}

	@Override
	public void deleteStudentOnly() {
		Session session = sf.openSession();
		System.out.println("Enter Stuid : ");
		Student s = session.get(Student.class, sc.nextInt());

		if (s != null) {

			List<Subject> list = s.getList();
			s.setList(null);

			for (Subject sub : list) {

				sub.setStudent(null);

			}

			session.delete(s);
			session.beginTransaction().commit();

		} else {
			System.out.println("Invalid Id");
		}

	}

	public void updateSubjectUsingSid() {
		Session session = sf.openSession();
		System.out.println("Enter Stuid : ");
		Student s = session.get(Student.class, sc.nextInt());

		if (s != null) {

			System.out.println("Enter sub id ");
			int subid = sc.nextInt();

			for (Subject sub : s.getList()) {

				if (sub.getSubid() == subid) {
					System.out.println("Enter Subject name : ");
					sub.setSubname(sc.next());
					session.update(sub);
					session.beginTransaction().commit();
				}

			}

		} else {
			System.out.println("Invalid Id");
		}
	}

	@Override
	public void AddExistingPersonToExistingAadharcard() {

		Session session = sf.openSession();
		System.out.println("Enter Sid: ");
		Student s = session.get(Student.class, sc.nextInt());
		List<Subject> sb = new ArrayList<Subject>();
		if (s != null) {

			System.out.println("Enter SubID: ");

			System.out.println("Enter how many Sub you wan to add :- ");
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				System.out.println("ENter the " + i + " id :- ");
				Subject sub = session.get(Subject.class, sc.nextInt());
				if (sub != null) {

					sb.add(sub);
					System.out.println("Sub addedd in list ");
				}
			}

			if (sb != null) {

				s.setList(sb);
				session.update(s);
				session.beginTransaction().commit();

			}

		} else {
			System.out.println("Invalid Student ID!!!!!!!!!");
		}

	}

}
