package tw.edu.fju.miniclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/patient") // 這會讓所有病人頁面的網址都以 /patient 開頭
public class PatientPageController {

    // 1. 病人主頁面 (例如訪問 http://localhost:8080/patient/home)
    @GetMapping("/home")
    public String patientHomePage() {
        // 這裡回傳的字串，必須對應到 src/main/resources/templates/ 裡面的 html 檔名
        // 假設你的 HTML 叫做 patient_home.html 或 patientpage.html
        return "patient_home"; 
    }

    // 2. 如果有病人看診紀錄或預約頁面，可以繼續延伸
    @GetMapping("/appointment")
    public String patientAppointmentPage() {
        return "patient_appointment"; // 對應到 patient_appointment.html
    }
}