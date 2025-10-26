
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.test.SinhVien;
import com.example.test.SinhVienService;

public class SinhVienTest {
    private SinhVienService sinhVienService;

    @BeforeEach
    void setup() {
        sinhVienService = new SinhVienService();
    }

    @Test
    void addSV() {
        SinhVien sinhVien = new SinhVien("th01", "Duy", 23, 4.5F, 3, "CNTT");
        sinhVienService.add(sinhVien);
        List<SinhVien> sinhViens = sinhVienService.getAll();
        assertTrue(sinhViens.contains(sinhVien), "Danh sach sinh vien vua them 1 sinh vien moi !");
        System.out.println("Danh sv da duoc them 1 sinh vien");
    }

    @Test
    void testAddInvalidMajor() {
        SinhVien sv = new SinhVien("SV008", "Quân", 23, 8.0F, 2, "e");
        assertThrows(IllegalArgumentException.class, () -> sinhVienService.add(sv));
    }

    @Test
    void updateSV() {
        SinhVien sinhVien = new SinhVien("SV00002", "Minh update", 2, 5.6F, 4, "fwf");
        sinhVienService.update("SV00001", sinhVien);
        SinhVien sinhVien2 = sinhVienService.findById("SV00001");
        assertEquals("Minh update", sinhVien2.getName());
        assertEquals(5.6F, sinhVien2.getAvgMark());
        System.out.println(sinhVien2.getName());
        System.out.println(sinhVien2.getAvgMark());
    }

}
