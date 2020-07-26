package super_project.db.cascades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;

import super_project.db.models.User;

public class UserCascade extends AbstractMongoEventListener<Object> {
    @Autowired
    private MongoOperations mongoOperations;
 
    @Override
    public void onBeforeSave(BeforeSaveEvent<Object> event) {
        Object source = event.getSource();
        
        if (source instanceof User) {
        	if (((User) source).getAddress() != null) {
        		mongoOperations.save(((User) source).getAddress());
        	}
            if (((User) source).getContacts() != null) {
                mongoOperations.save(((User) source).getContacts());
            }
        }
    }
//   @Override
//    public void onBeforeConvert(BeforeConvertEvent<Object> event) {
//        Object source = event.getSource();
//        
//        if (source instanceof User) {
//        	if (((User) source).getAddress() != null) {
//        		mongoOperations.save(((User) source).getAddress());
//        	}
//            if (((User) source).getContacts() != null) {
//                mongoOperations.save(((User) source).getContacts());
//            }
//        }
//    }
}
