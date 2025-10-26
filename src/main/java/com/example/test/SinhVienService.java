package com.example.test;

import java.util.ArrayList;
import java.util.List;
import com.example.test.SinhVien;

public class SinhVienService {
    public final List<SinhVien> list = new ArrayList<>();

    public SinhVienService() {
        list.add(new SinhVien("SV00001", "Nguyễn Tường Minh", 20, 8.5F, 3, "CNTT"));
    }

    public void add(SinhVien sinhVien) {
        if (sinhVien == null) {
            throw new IllegalArgumentException("Sinh vien khong duoc null");

        }
        if (sinhVien.getId() == null || sinhVien.getId().isEmpty()) {

        }
        list.add(sinhVien);
    }

    public SinhVien findById(String id) {
        for (SinhVien sinhVien : list) {
            if (sinhVien.getId().equals(id)) {
                return sinhVien;
            }
        }
        return null;
    }

    public void update(String id, SinhVien sinhVien) {
        SinhVien sinhVien1 = findById(id);
        if (sinhVien1 == null)
            throw new IllegalArgumentException("Khong tim thya sinhvien");
        sinhVien1.setName(sinhVien.getName());
        sinhVien1.setAge(sinhVien.getAge());
        sinhVien1.setAvgMark(sinhVien.getAvgMark());
        sinhVien1.setSemester(sinhVien.getSemester());
        sinhVien1.setMajor(sinhVien.getMajor());
    }

    public void deleteSinhVien(String id) {
        SinhVien sinhVien = findById(id);
        if (sinhVien == null) {
            throw new IllegalArgumentException("Khong tim thay thg nao ca");
        }
        list.remove(id);
    }

    public List<SinhVien> getAll() {
        return list;
    }

}
