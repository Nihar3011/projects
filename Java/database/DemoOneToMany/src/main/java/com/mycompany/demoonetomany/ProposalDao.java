package com.mycompany.demoonetomany;

import com.mycompany.demoonetomany.model.Attachment;
import com.mycompany.demoonetomany.model.Personnel;
import com.mycompany.demoonetomany.model.Proposal;
import com.mycompany.demoonetomany.model.QualificationLevel;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author nihar
 */
public class ProposalDao {

    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

    /**
     * 
     * @return created proposal
     */
    private Proposal createProposal() {

        byte[] myvar = "Any String you want".getBytes();
        List<Personnel> personnel = new ArrayList<>();
        personnel.add(new Personnel("Nihar", QualificationLevel.Beginner, "9714319500"));
        personnel.add(new Personnel("Raj", QualificationLevel.Beginner, "9714319500"));

        List<Attachment> attachment = new ArrayList<>();
        attachment.add(new Attachment("FILE!", "200", myvar));
        Proposal proposal = new Proposal("Argus", "It's nice", personnel, attachment);
        return proposal;
    }
    
    /**
     * 
     * @param id
     * @return proposal
     */
    private Proposal getOne(Long id) {

        return entityManager.getReference(Proposal.class, id);
    }
    
    /**
     * Add proposal in database
     */
    public void addProposal() {

        entityManager.getTransaction().begin();
        entityManager.merge(createProposal());
        entityManager.getTransaction().commit();

    }
    /**
     * 
     * @return List of proposal
     */
    public List<Proposal> getProposal() {

        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("from Proposal");
        List<Proposal> students = query.getResultList();
        entityManager.getTransaction().commit();
        return students;
    }
    /**
     * 
     * @param id 
     * Delete proposal from database
     */
    public void deleteProposal(Long id) {

        entityManager.getTransaction().begin();
        Proposal proposal = getOne(id);
        entityManager.remove(proposal);
        entityManager.getTransaction().commit();

    }
    
    /**
     * 
     * @param id 
     * Update proposal from database
     */
    public void updateProposal(Long id) {

        entityManager.getTransaction().begin();
        Proposal proposal = getOne(id);
        proposal.setTitle("abc");
        entityManager.getTransaction().commit();

    }

}
