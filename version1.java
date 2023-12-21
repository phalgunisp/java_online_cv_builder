package online_cv_builder;

import java.util.Scanner;

interface CV 
{
    void display_details();
}

class Personal_Details implements CV 
{
    String name;
    int date_of_birth;
    String address;
    int age;
    long contact;

    public void this_keyword(String name, int date_of_birth, String address, int age, long contact) 
    {
        this.name = name;
        this.date_of_birth = date_of_birth;
        this.address = address;
        this.age = age;
        this.contact = contact;
    }

    public void display_details() 
    {
        System.out.println("Name:\n" + name);
        System.out.println("Date of Birth:\n" + date_of_birth);
        System.out.println("Address:\n" + address);
        System.out.println("Age:\n" + age);
        System.out.println("Contact:\n" + contact);
    }
}

class Education_Details implements CV 
{
    String school_name;
    String university_name_undergraduate;
    String undergraduate_major;
    String university_name_graduate;
    String graduate_major;
    String university_name_Phd;
    String phd_major;
    String university_name_Others[];

    public Education_Details() 
    {
        university_name_Others = new String[1000];
    }

    public void display_details() 
    {
        System.out.println("School Name:\n" + school_name);
        System.out.println("University Name (Under Graduate):\n" + university_name_undergraduate);
        System.out.println("Major Subject:\n" + undergraduate_major);
        System.out.println("University Name (Graduate):\n" + university_name_graduate);
        System.out.println("Major Subject:\n" + graduate_major);
        System.out.println("University Name (Phd):\n" + university_name_Phd);
        System.out.println("Major Subject:\n" + phd_major);
        for (String universityNameOther : university_name_Others) 
        {
            if (universityNameOther != null) 
            {
                System.out.println("University Name:\n" + universityNameOther);
            }
        }
    }
}

class Work_Experience implements CV 
{
    String[] experiences;

    public Work_Experience() 
    {
        experiences = new String[100];
    }

    public void display_details()
    {
        System.out.println("Work Experience:");
        if (experiences != null) 
        {
            for (String experience : experiences) 
            {
                if (experience != null) 
                {
                    System.out.println(experience);
                }
            }
        } 
        else 
        {
            System.out.println("No work experience provided.");
        }
    }
}

public class version1
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        Personal_Details pd = new Personal_Details();
        Education_Details ed = new Education_Details();
        Work_Experience we = new Work_Experience();

        System.out.println("Choose an option:");
        System.out.println("1. Fill the Resume Form.");
        System.out.println("2. Display the Resume.");
        System.out.println("3. Quit.");

        while (true) 
        {
            System.out.println("Enter the number of your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) 
            {
                System.out.println("Enter Your Full Name:");
                String name = sc.nextLine();
                System.out.println("Enter Your Date of Birth(DDMMYYYY):");
                int date_of_birth = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter Your Permanent Address:");
                String address = sc.nextLine();
                System.out.println("Enter Your Age in Numerals:");
                int age = sc.nextInt();
                System.out.println("Enter Your Contact Number:");
                long contact = sc.nextLong();
                sc.nextLine();

                pd.this_keyword(name, date_of_birth, address, age, contact);

                System.out.println("Enter School Name:");
                ed.school_name = sc.nextLine();
                System.out.println("Have you finished your Undergraduate? (yes = 1/no = 0)");
                int option1 = sc.nextInt();
                sc.nextLine();
                if (option1 == 1) 
                {
                    System.out.println("Enter Your University Name (Undergraduate):");
                    ed.university_name_undergraduate = sc.nextLine();
                    System.out.println("Enter Your Major:");
                    ed.undergraduate_major = sc.nextLine();
                }

                System.out.println("Have you finished your Graduate? (yes = 1/no = 0)");
                int option2 = sc.nextInt();
                sc.nextLine();
                if (option2 == 1)
                {
                    System.out.println("Enter Your University Name (Graduate):");
                    ed.university_name_graduate = sc.nextLine();
                    System.out.println("Enter Your Major:");
                    ed.graduate_major = sc.nextLine();
                }

                System.out.println("Have you finished your Post Doctrate? (yes = 1/no = 0)");
                int option3 = sc.nextInt();
                sc.nextLine();
                if (option3 == 1) 
                {
                    System.out.println("Enter Your University Name (Post Graduate):");
                    ed.university_name_Phd = sc.nextLine();
                    System.out.println("Enter Your Major:");
                    ed.phd_major = sc.nextLine();
                }

                System.out.println("Have you attended any other University? (yes = 1/no = 0)");
                int option4 = sc.nextInt();
                sc.nextLine();
                if (option4 == 1) 
                {
                    System.out.println("Enter Your University Name (If any):");
                    String universityInput = sc.next();
                    ed.university_name_Others = universityInput.split(",");
                }

                System.out.println("Do you Have any Work Experience? (yes = 1/no = 0)");
                String workExperienceOption = sc.nextLine();
                
                if (workExperienceOption.equals("1")) 
                {
                    System.out.println("Enter Your Experiences (comma-separated if multiple):");
                    String experiencesInput = sc.nextLine();
                    we.experiences = experiencesInput.split(",");
                } 
                else if (workExperienceOption.equals("0")) 
                {
                    ;
                } 
                
            }
            else if (choice == 2) 
            {
                pd.display_details();
                ed.display_details();
                we.display_details();
            } 
            else     
            {
                break;
            }
        } 
    }
}
