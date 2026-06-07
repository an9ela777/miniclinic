package tw.edu.fju.miniclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import tw.edu.fju.miniclinic.model.*;

import java.time.LocalDate;
import java.util.*;

@Controller
public class StatsController {

    @Autowired
    private DoctorRepository doctorRepo;

    @Autowired
    private PatientRepository patientRepo;

    @Autowired
    private AppointmentRepository appointmentRepo;

    @GetMapping("/stats")
    public String showStatsPage(Model model) {
        // 基礎計數統計
        model.addAttribute("doctorCount", doctorRepo.count());
        model.addAttribute("patientCount", patientRepo.count());
        model.addAttribute("appointmentCount", appointmentRepo.count());

        // 依科別分組統計資料處理
        List<Object[]> deptStatsRaw = appointmentRepo.countAppointmentsByDepartment();
        Map<String, Long> deptStats = new LinkedHashMap<>();
        for (Object[] row : deptStatsRaw) {
            deptStats.put((String) row[0], (Long) row[1]);
        }
        model.addAttribute("deptStats", deptStats);

        return "stats"; // 對應 src/main/resources/templates/stats.html
    }
}