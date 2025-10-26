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
            throw new IllegalArgumentException("ID khong duoc null");
        }
        if (sinhVien.getMajor() == null || sinhVien.getMajor().trim().isEmpty() || sinhVien.getMajor().length() < 3) {
            throw new IllegalArgumentException("Chuyên ngành không hợp lệ");
        }
        if (sinhVien.getName() == null || sinhVien.getName().isEmpty()) {
            throw new IllegalArgumentException("Ten khong duoc rong hoac null");
        }
        if (sinhVien.getAge() < 18 || sinhVien.getAge() > 60) {
            throw new IllegalArgumentException("Tuoi khong duoc be hon 18 va lon hon 60");
        }
        if (sinhVien.getAvgMark() < 0 || sinhVien.getAvgMark() > 10) {
            throw new IllegalArgumentException("Diem khong duoc am hoac lon hon 10");
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
