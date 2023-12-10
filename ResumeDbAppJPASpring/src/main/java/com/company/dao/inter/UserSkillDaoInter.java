/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.inter;

import com.company.entity.UserSkill;

import java.util.List;

/**
 *
 * @author HP 
 */
public interface UserSkillDaoInter {
   
    public List<UserSkill> getAllSkillByUserId(int userId);
    public boolean removeSkill(int id);
     public boolean insertSkill(UserSkill us);
     public boolean updateUserSkill(UserSkill u);
    
}
