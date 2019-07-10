package com.onlinevoting.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.onlinevoting.model.VoterDetails;

public class ManageData {

	public void saveData(String name, String email, String id, String password){
		
		Configuration c = new Configuration();
		c.configure("com/onlinevoting/controller/hibernate.cfg.xml");
		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		VoterDetails vd = new VoterDetails();
		vd.setEmailID(email);
		vd.setFullName(name);
		vd.setVoterID(id);
		vd.setPassWord(password);

		s.save(vd);
		tx.commit();
	}

}
