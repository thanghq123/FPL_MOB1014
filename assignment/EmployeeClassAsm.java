/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.util.Scanner;

/**
 *
 * @author QuangVinh
 */
public class EmployeeClassAsm {

    String id;
    String name;
    double salary;
    double commissionRate;
    double responSalary;
    double sale;
    int choice;
    int position_id;
    static Scanner input = new Scanner(System.in);

    public EmployeeClassAsm() {
    }

    public EmployeeClassAsm(String id, String name, double salary, double commissionRate, double responSalary, double sale, int choice, int position_id) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.commissionRate = commissionRate;
        this.responSalary = responSalary;
        this.sale = sale;
        this.choice = choice;
        this.position_id = position_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public double getResponSalary() {
        return responSalary;
    }

    public void setResponSalary(double responSalary) {
        this.responSalary = responSalary;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }

    public double getPosition_id() {
        return position_id;
    }

    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public void setData() {
        System.out.println("Phan loai nhan vien");
        System.out.println("1. Nhan vien hanh chinh");
        System.out.println("2. Nhan vien tiep thi");
        System.out.println("3. Truong phong");
        do {
            try {
                System.out.print("Lua chon cua ban: ");
                position_id = Integer.parseInt(input.nextLine());
                if (position_id < 1 || position_id > 3) {
                    System.out.println("Lua chon khong hop le. Hay nhap lai.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Gia tri nhap khong hop le. Hay nhap lai.");
            }
        } while (true);
        System.out.print("Hay nhap vao ma nhan vien: ");
        id = input.nextLine();
        System.out.print("Hay nhap vao ten cua nhan vien: ");
        name = input.nextLine();
        salary = inputNum("luong nhan vien (trieu dong)");

        switch (position_id) {
            case 1:
                break;
            case 2:
                sale = inputNum("doanh so ban hang");
                commissionRate = inputNum("ti le hoa hong (%)");
                break;
            case 3:
                responSalary = inputNum("luong trach nhiem");
                break;
        }
    }

    public void updateData(String id_input) {
        System.out.println("Phan loai nhan vien");
        System.out.println("1. Nhan vien hanh chinh");
        System.out.println("2. Nhan vien tiep thi");
        System.out.println("3. Truong phong");
        do {
            try {
                System.out.print("Lua chon cua ban: ");
                position_id = Integer.parseInt(input.nextLine());
                if (position_id < 1 || position_id > 3) {
                    System.out.println("Lua chon khong hop le. Hay nhap lai.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Gia tri nhap khong hop le. Hay nhap lai.");
            }
        } while (true);
        id = id_input;
        System.out.print("Hay nhap vao ten cua nhan vien: ");
        name = input.nextLine();
        salary = inputNum("luong nhan vien (trieu dong)");

        switch (position_id) {
            case 1:
                break;
            case 2:
                sale = inputNum("doanh so ban hang (trieu dong)");
                commissionRate = inputNum("ti le hoa hong (%)");
                break;
            case 3:
                responSalary = inputNum("luong trach nhiem (trieu dong)");
                break;
        }
    }

    public void showFullData() {
        System.out.println("Ma nhan vien: " + id);
        System.out.println("Ten nhan vien: " + name);
        System.out.printf("Luong nhan vien: %.1f trieu VND", salary);
        if (sale != 0 && commissionRate != 0) {
            System.out.println("\nDoanh so ban hang: " + sale + " trieu VND");
            System.out.print("Ty le hoa hong:  " + commissionRate + "%");

        } else if (responSalary != 0) {
            System.out.printf("\nLuong trach nhiem: %.1f trieu VND", responSalary);
        }
        System.out.printf("\nTong luong: %.1f trieu VND\n", getTotalSalary());
        System.out.printf("Thue phai dong: %.1f trieu VND\n", getIncomeTax());
        System.out.println("");
    }

    public void showSubData() {
        System.out.printf("Ma: %s | Ten: %s | Luong: %.1f trieu VND\n", id, name, getTotalSalary());
    }

    public double getTotalSalary() {
        double totalSalary;
        if (sale != 0 && commissionRate != 0) {
            totalSalary = salary + sale * (commissionRate / 100);
        } else if (responSalary != 0) {
            totalSalary = salary + responSalary;
        } else {
            totalSalary = salary;
        }
        return totalSalary;
    }

    public double getIncomeTax() {
        double incomeTaxPer;
        if (getTotalSalary() < 9) {
            incomeTaxPer = 0;
        } else if (getTotalSalary() >= 9 && getTotalSalary() <= 15) {
            incomeTaxPer = 0.1;
        } else {
            incomeTaxPer = 0.12;
        }
        return getTotalSalary() * incomeTaxPer;
    }

    public int inputNum(String nameNum) {
        int num;
        do {
            try {
                System.out.printf("Hay nhap vao %s: ", nameNum);
                num = Integer.parseInt(input.nextLine());
                if (num <= 0) {
                    System.out.println("Gia tri nhap khong hop le. Hay nhap lai");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Gia tri nhap khong hop le. Hay nhap lai");
            }
        } while (true);
        return num;
    }
}