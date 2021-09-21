
  package com.unfoldhappiness_admin.daoimpl;
  
  import java.util.List;
  
  import org.springframework.stereotype.Repository;
  
  import com.unfoldhappiness_admin.dao.EventDao; 
  import com.unfoldhappiness_admin.model.Event; 
  import com.unfoldhappiness_admin.model.Ngo;
  
  
  
  
  @Repository("eventdao")
  public class EventDaoImpl extends GenericDaoImpl<Event> implements EventDao 
  {
  
  @Override
  public int saveEvent(Event event) 
  {
	  super.saveObject(event); 
	  return 0; 
   }
  
  @Override 
  public List<Event> getAll() 
  { 
	  // TODO Auto-generated method stub
	  List<Event> list=(List<Event>)super.getByQuery("FROM Event e WHERE e.isdelete=0"); 
	  return list; 
  }
  
  @Override
  public Event getById(int id) 
  {
	  // TODO Auto-generated method stub  
	  return super.getById(Event.class, id); 
  }
  
  @Override
  public int editEvent(Event event) 
  { 
	  super.updateObject(event);
	  return 0; 
  }
  
  @Override 
  public Boolean deleteEvent(long id) 
  {
	  Event event =super.getById(Event.class, id); 
	  event.setIsdelete(1); 
	  return super.updateObject(event).getId()>0; 
  }
  
  }
 