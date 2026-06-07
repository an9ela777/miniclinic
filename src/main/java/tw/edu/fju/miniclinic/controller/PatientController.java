package tw.edu.fju.miniclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tw.edu.fju.miniclinic.model.Patient;
import tw.edu.fju.miniclinic.model.PatientRepository;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PatientController {

    @Autowired
    private PatientRepository patientRepo;

    // 1. 顯示病患清單頁面 (Thymeleaf)
    @GetMapping("/patients")
    public String showPatients(Model model) {
        model.addAttribute("patients", patientRepo.findAll());
        return "patients"; // 對應 templates/patients.html
    }

    // 2. 回傳病患資料 JSON 陣列 (API)
    @GetMapping("/api/patients")
    @ResponseBody // 加上這個註解，Spring 會自動把 List 轉成 JSON
    public List<Patient> getPatientsApi() {
        return patientRepo.findAll();
    }

    // 🛠️ 補上這段：根據病歷號查詢單一病患 JSON (API)
    @GetMapping("/api/patients/{chartNo}")
    @ResponseBody
    public org.springframework.http.ResponseEntity<Patient> getPatientByChartNo(@PathVariable String chartNo) {
        @SuppressWarnings("null")
        java.util.Optional<Patient> patientOpt = patientRepo.findById(chartNo);
        
        return patientOpt
                .map(patient -> org.springframework.http.ResponseEntity.ok(patient)) // 找到就回傳 200 OK
                .orElse(org.springframework.http.ResponseEntity.notFound().build()); // 沒找到就回傳 404
    }
} 