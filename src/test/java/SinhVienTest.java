import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
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

    // ✅ 1. Thêm sinh viên hợp lệ
    @Test
    void addSV() {
        SinhVien sinhVien = new SinhVien("th01", "Duy", 23, 4.5F, 3, "CNTT");
        sinhVienService.add(sinhVien);
        List<SinhVien> sinhViens = sinhVienService.getAll();
        assertTrue(sinhViens.contains(sinhVien), "Danh sách sinh viên phải chứa sinh viên vừa thêm");
    }

    // ✅ 2. ID rỗng
    @Test
    void addIDRong() {
        SinhVien sinhVien = new SinhVien("", "Duy", 23, 4.5F, 3, "CNTT");
        assertThrows(IllegalArgumentException.class, () -> sinhVienService.add(sinhVien),
                "Phải báo lỗi khi ID rỗng");
    }

    // ✅ 3. ID null
    @Test
    void addIDNull() {
        SinhVien sinhVien = new SinhVien(null, "Duy", 23, 4.5F, 3, "CNTT");
        assertThrows(IllegalArgumentException.class, () -> sinhVienService.add(sinhVien),
                "Phải báo lỗi khi ID null");
    }

    // ✅ 4. Tên null
    @Test
    void addNameNull() {
        SinhVien sinhVien = new SinhVien("TH002", null, 23, 4.5F, 3, "CNTT");
        assertThrows(IllegalArgumentException.class, () -> sinhVienService.add(sinhVien),
                "Phải báo lỗi khi tên null");
    }

    // ✅ 5. Tên rỗng
    @Test
    void addNameRong() {
        SinhVien sinhVien = new SinhVien("TH002", "", 23, 4.5F, 3, "CNTT");
        assertThrows(IllegalArgumentException.class, () -> sinhVienService.add(sinhVien),
                "Phải báo lỗi khi tên rỗng");
    }

    // ✅ 6. Tuổi âm
    @Test
    void addTuoiAm() {
        SinhVien sinhVien = new SinhVien("TH002", "Duy Hung", -1, 4.5F, 3, "CNTT");
        assertThrows(IllegalArgumentException.class, () -> sinhVienService.add(sinhVien),
                "Phải báo lỗi khi tuổi âm");
    }

    // ✅ 7. Tuổi quá lớn
    @Test
    void addTuoiQuaLon() {
        SinhVien sinhVien = new SinhVien("TH002", "Duy Hung", 61, 4.5F, 3, "CNTT");
        assertThrows(IllegalArgumentException.class, () -> sinhVienService.add(sinhVien),
                "Phải báo lỗi khi tuổi > 60");
    }

    // ✅ 8. Điểm nhỏ hơn 0
    @Test
    void addDiemBeHon0() {
        SinhVien sinhVien = new SinhVien("TH002", "Duy Hung", 23, -4.5F, 3, "CNTT");
        assertThrows(IllegalArgumentException.class, () -> sinhVienService.add(sinhVien),
                "Phải báo lỗi khi điểm âm");
    }

    // ✅ 9. Điểm lớn hơn 10
    @Test
    void addDiemLonHonMax() {
        SinhVien sinhVien = new SinhVien("TH002", "Duy Hung", 25, 11.5F, 3, "CNTT");
        assertThrows(IllegalArgumentException.class, () -> sinhVienService.add(sinhVien),
                "Phải báo lỗi khi điểm > 10");
    }

    // ✅ 10. Ngành học không hợp lệ
    @Test
    void testAddInvalidMajor() {
        SinhVien sv = new SinhVien("SV008", "Quân", 23, 8.0F, 2, "e");
        assertThrows(IllegalArgumentException.class, () -> sinhVienService.add(sv),
                "Phải báo lỗi khi ngành không hợp lệ");
    }

    // ✅ 11. Cập nhật sinh viên
    @Test
    void updateSV() {
        SinhVien sinhVienMoi = new SinhVien("SV00001", "Minh update", 22, 5.6F, 4, "CNTT");
        sinhVienService.update("SV00001", sinhVienMoi);

        SinhVien svCapNhat = sinhVienService.findById("SV00001");
        assertEquals("Minh update", svCapNhat.getName(), "Tên sinh viên phải được cập nhật");
        assertEquals(5.6F, svCapNhat.getAvgMark(), "Điểm trung bình phải được cập nhật");
    }
}
