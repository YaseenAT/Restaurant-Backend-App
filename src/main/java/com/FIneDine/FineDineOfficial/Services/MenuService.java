package com.FIneDine.FineDineOfficial.Services;

import com.FIneDine.FineDineOfficial.Model.MenuList;
import com.FIneDine.FineDineOfficial.Repository.MenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@Service
public class MenuService {

    @Autowired
    private MenuRepo repo;

    public List<MenuList> getMenuList() {
        System.out.println(repo.findAll().toString()+"LIST--------------->");
        return repo.findAll();
    }

    public void updateMenu(MenuList menu) {
        System.out.println(menu);
        repo.save(menu);
    }


    public void createMenu(MenuList menu) {
        repo.save(menu);
    }

    public void deleteMenu(int id) {
        repo.deleteById(id);
    }

    public MenuList addMenuWithImage(MenuList menu, MultipartFile imageFile) throws IOException {

        menu.setImageName(imageFile.getOriginalFilename());
        menu.setImageType(imageFile.getContentType());
        menu.setImageData(imageFile.getBytes());

        return repo.save(menu);
    }
}
