package com.project.placa.mae.service;

import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.placa.mae.exception.PermissionException;
import com.project.placa.mae.exception.UsernameNotFoundException;
import com.project.placa.mae.exception.UsernameOrEmailAlreadyExists;
import com.project.placa.mae.model.PeopleAdmin;
import com.project.placa.mae.repository.DAOPeopleAdmin;

@Service
public class PeopleAdminService {
    @Autowired
    private DAOPeopleAdmin peopleAdminRepository;

    public void PeopleKidService(DAOPeopleAdmin peopleAdminRepository) {
        this.peopleAdminRepository = peopleAdminRepository;
    }

    // Create a new people category admin
    public PeopleAdmin createKids(PeopleAdmin kids) throws UsernameOrEmailAlreadyExists {
        boolean verifyExists = usernameVerify(kids.getUsername());

        if (!verifyExists) {
            throw new UsernameOrEmailAlreadyExists("Username already exists");
        }


        return peopleAdminRepository.save(kids);
    }

    // Update existing people category admin
    public PeopleAdmin updatKids(PeopleAdmin admin, long id) throws Exception {
        Optional<PeopleAdmin> optionalObj = peopleAdminRepository.findById(id);
        PeopleAdmin peopleAdmin = optionalObj.get();

        peopleAdmin.setEmail(!Objects.isNull(admin.getEmail()) ? admin.getEmail() : peopleAdmin.getEmail());
        peopleAdmin.setPassword(!Objects.isNull(admin.getPassword()) ? admin.getPassword() : peopleAdmin.getPassword());
        peopleAdmin.setUsername(!Objects.isNull(admin.getUsername()) ? admin.getUsername() : peopleAdmin.getUsername());
        admin = peopleAdminRepository.save(peopleAdmin);

        return ResponseEntity.ok().body(admin).getBody();

    }

    // Find people by id
    public PeopleAdmin findById(Long id) {
        return peopleAdminRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("People id not found: " + id) );
    }

    // Verify username already exists
    public boolean usernameVerify (String username)
            throws UsernameNotFoundException {

        if (username.isEmpty()) {
            throw new UsernameNotFoundException(
                    "The user name can't be empty: " + username);
        }

        try {

            return  peopleAdminRepository.existsByUsername(username);

        } catch(Exception exception) {

            return false;
        }
    }
    
    /*
     * Users admin can create posts related to category specified by ages of the user.
     */
    public void postArticle(long peopleAdminID) throws PermissionException {
        
        PeopleAdmin admin = findById(peopleAdminID);

        if (admin == null) {
            throw new PermissionException("User permission denied");
        }
        else {

        }


    }

}
