import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PetCareScheduler {
    public static void main(String[] args) throws Exception {

        boolean running = true;
        Scanner sc = new Scanner(System.in);

        String tempName;
        String tempBreed;
        byte tempAge;
        String tempOwnerName;
        String tempContactInfo;

        Map<Integer, Pet> pets = new HashMap<>();
        Map<LocalDateTime, Appointment> appointments = new HashMap<>();
        // Preloads old data
        java.io.File saveFile = new java.io.File("petcare_data.txt");
        if (saveFile.exists()) {
            Scanner fileSc = new Scanner(saveFile);

            while (fileSc.hasNextLine()) {
                String line = fileSc.nextLine();

                if (line.startsWith("PET|")) {
                    String[] parts = line.split("\\|", -1);

                    int petId = Integer.parseInt(parts[1]);
                    String name = parts[2];
                    String breed = parts[3];
                    byte age = Byte.parseByte(parts[4]);
                    String ownerName = parts[5];
                    String contactInfo = parts[6];

                    Pet pet = new Pet(name, breed, age, ownerName, contactInfo);
                    pets.put(petId, pet);
                }

                if (line.startsWith("APPT|")) {
                    String[] parts = line.split("\\|", -1);

                    int petId = Integer.parseInt(parts[1]);
                    LocalDateTime dateTime = LocalDateTime.parse(parts[2]);
                    String type = parts[3];
                    String notes = parts[4];

                    Appointment appt = new Appointment(petId, dateTime, type, notes);
                    appointments.put(dateTime, appt);
                }
            }

            fileSc.close();
            System.out.println("Saved data loaded.");
        }
        // runs!
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        try {
            do {
                System.out.print(
                        "Please select an option: \n" +
                        " 1: Register a new pet \n" +
                        " 2: Register for an appointment \n" +
                        " 3: generate a report \n" +
                        " 4: Display details of a Pet \n" +
                        " 5: store details to a file \n" +
                        " 6: Exit Program \n");

                String input = sc.nextLine();
                int choice = Integer.parseInt(input.trim());

                if (choice == 1) {
                    System.out.println("Please enter your Pet's Name");
                    tempName = sc.nextLine();

                    System.out.println("Please enter your Pet's Breed");
                    tempBreed = sc.nextLine();

                    System.out.println("Please enter your Pet's Age");
                    tempAge = Byte.parseByte(sc.nextLine().trim());

                    System.out.println("Please enter the Owner's Name");
                    tempOwnerName = sc.nextLine();

                    System.out.println("Please enter Contact Info");
                    tempContactInfo = sc.nextLine();

                    Pet newPet = new Pet(tempName, tempBreed, tempAge, tempOwnerName, tempContactInfo);
                    pets.put(newPet.getPetId(), newPet);

                    System.out.println("Pet registered with ID: " + newPet.getPetId());
                }

                if (choice == 2) {
                    if (pets.isEmpty()) {
                        System.out.println("No pets are registered yet.");
                    } else {
                        System.out.println("Enter the Pet ID for this appointment:");
                        int petId = Integer.parseInt(sc.nextLine().trim());

                        Pet selectedPet = pets.get(petId);

                        if (selectedPet == null) {
                            System.out.println("No pet found with that ID.");
                        } else {
                            System.out.println("Enter appointment date and time (yyyy-MM-dd HH:mm):");
                            LocalDateTime dateTime = LocalDateTime.parse(sc.nextLine().trim(), dtf);

                            System.out.println("Enter appointment type:");
                            String appointmentType = sc.nextLine();

                            System.out.println("Enter notes (or leave blank):");
                            String notes = sc.nextLine();

                            Appointment newAppointment = new Appointment(petId, dateTime, appointmentType, notes);
                            appointments.put(dateTime, newAppointment);

                            System.out.println("Appointment registered for " + selectedPet.getName());
                        }
                    }
                }

                if (choice == 3) {
                    System.out.println("---- REPORT ----");
                    System.out.println("Number of pets registered: " + pets.size());
                    System.out.println("Number of appointments: " + appointments.size());

                    System.out.println("Pets:");
                    for (Pet pet : pets.values()) {
                        pet.printPetInfo();
                    }

                    System.out.println("Appointments:");
                    for (Appointment appointment : appointments.values()) {
                        System.out.println(appointment);
                    }
                }

                if (choice == 4) {
                    if (pets.isEmpty()) {
                        System.out.println("No pets are registered yet.");
                    } else {
                        System.out.println("Enter the Pet ID:");
                        int petId = Integer.parseInt(sc.nextLine().trim());

                        Pet pet = pets.get(petId);

                        if (pet == null) {
                            System.out.println("No pet found with that ID.");
                        } else {
                            pet.printPetInfo();

                            System.out.println("Appointments for this pet:");
                            boolean found = false;
                            for (Appointment appointment : appointments.values()) {
                                if (appointment.getPetId() == petId) {
                                    System.out.println(appointment);
                                    found = true;
                                }
                            }
                            if (!found) {
                                System.out.println("No appointments found for this pet.");
                            }
                        }
                    }
                }

                if (choice == 5) {
                   try (PrintWriter out = new PrintWriter(new FileWriter("petcare_data.txt"))) {

    for (Pet pet : pets.values()) {
        out.println("PET|" 
            + pet.getPetId() + "|"
            + pet.getName() + "|"
            + pet.getBreed() + "|"
            + pet.getAge() + "|"
            + pet.getOwnerName() + "|"
            + pet.getContactInfo());
    }

    for (Appointment appt : appointments.values()) {
        out.println("APPT|"
            + appt.getPetId() + "|"
            + appt.getDateAndTime() + "|"
            + appt.getAppointmentType() + "|"
            + appt.getNotes());
    }
}
                    System.out.println("Details stored to petcare_data.txt");
                }

                if (choice == 6) {
                    running = false;
                }

            } while (running);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}