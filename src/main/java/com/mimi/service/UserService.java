package com.mimi.service;

import com.mimi.modele.User;
import com.mimi.repository.UserRepository;
import com.mimi.exception.UserNotFoundException;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;



    public UserService(UserRepository userRepository) {
        this.userRepository=userRepository;
    }



    //----------- LISTE USERS + RECHERCHE/FILTRE -----------//



   public String fonctionUserList(String titleName, Model model, ModelMap modelMap,@Param("keyword") String keyword) {
       modelMap.put("titleName", titleName);
       if (keyword != null) {
           model.addAttribute("listUsers", userRepository.findAll(keyword));
       }else {
           model.addAttribute("listUsers", userRepository.findAll());
       }
           return "admin/gestionUser";
       }


    //----------- SAVE-----------//

    public User saveUser(User user)  {
            return  userRepository.save(user);
        }


    //----------- EDIT-----------//

    public User getUser(Integer  id) throws UserNotFoundException {
        Optional<User> getUser =userRepository.findById(id);
        if (getUser.isPresent()){
            return  getUser.get();
        }
        throw new UserNotFoundException("id introuvable"+ id);
    }

    //----------- DELETE-----------//
        public void deleteUser(Integer userId) throws UserNotFoundException {
        Integer count = userRepository.countByUserId(userId);
        if (count == null || count == 0) {
            throw new UserNotFoundException("id introuvable" + userId);
        }
        userRepository.deleteById(userId);
    }

}