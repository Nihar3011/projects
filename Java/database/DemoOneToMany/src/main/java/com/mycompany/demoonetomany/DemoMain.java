package com.mycompany.demoonetomany;

import com.mycompany.demoonetomany.model.Attachment;
import com.mycompany.demoonetomany.model.Personnel;
import com.mycompany.demoonetomany.model.Proposal;
import com.mycompany.demoonetomany.model.QualificationLevel;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author nihar
 */
public class DemoMain {

    public static void main(String[] args) {

        Logger logger = Logger.getLogger(DemoMain.class.getName());

        ProposalDao proposalDao = new ProposalDao();

        proposalDao.addProposal();
        logger.info("*************Proposal added*************");
        proposalDao.updateProposal(1L);
        logger.info("*************Proposal updated*************");
        proposalDao.getProposal().forEach(proposal -> logger.info(proposal.toString()));
        proposalDao.deleteProposal(1L);
        logger.info("*************Proposal Deleted*************");

        JPAUtil.shutdown();
    }

}
