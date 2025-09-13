package com.FIneDine.FineDineOfficial.Repository;

import com.FIneDine.FineDineOfficial.Model.MenuList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepo extends JpaRepository<MenuList,Integer> {
}
