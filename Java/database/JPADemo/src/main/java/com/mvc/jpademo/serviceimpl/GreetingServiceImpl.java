
package com.mvc.jpademo.serviceimpl;

import com.mvc.jpademo.dao.GreetingDao;
import com.mvc.jpademo.model.Greetings;

/**
 *
 * @author nihar
 */
public class GreetingServiceImpl {
    
    private GreetingDao greetingDao;

    public GreetingServiceImpl() {
        this.greetingDao = new GreetingDao();
    }
    
    public void createHelloWorld(Greetings greetings){
        greetingDao.createHelloWorld(greetings);
    }
    
    public Greetings getHelloWorldById(int id){
        return greetingDao.getHelloWorldById(id);
    }
    
}
