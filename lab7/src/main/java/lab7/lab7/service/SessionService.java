package lab7.lab7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;

@Service
public class SessionService {
    @Autowired
    HttpSession session;

    // Đọc giá trị của attribute trong session 
    @SuppressWarnings("unchecked")
    public <T> T get(String name){
        return (T) session.getAttribute(name);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String name, T defaultValue) {
        T value = (T) session.getAttribute(name);
        return (value != null) ? value : defaultValue;
    }
    
    // Thay đổi hoặc tạo mới attribute trong session
    public void set(String name, Object value){
        session.setAttribute(name, value);
    }

    // Xóa attribute trong session
    public void remove(String name){
        session.removeAttribute(name);
    }
}   
