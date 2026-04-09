import java.time.LocalDate;

public class Pet {
    private static int idCounter = 1;

    private final int petId;
    private String name;
    private String breed;
    private byte age;
    private String ownerName;
    private String contactInfo;
    private LocalDate registrationDate;

    public Pet(String name, String breed, byte age, String ownerName, String contactInfo) {
        if (age < 0) {
            throw new IllegalArgumentException("Pet age cannot be negative.");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Pet name cannot be blank.");
        }
        if (breed == null || breed.isBlank()) {
            throw new IllegalArgumentException("Pet breed cannot be blank.");
        }
        if (ownerName == null || ownerName.isBlank()) {
            throw new IllegalArgumentException("Owner name cannot be blank.");
        }
        if (contactInfo == null || contactInfo.isBlank()) {
            throw new IllegalArgumentException("Contact info cannot be blank.");
        }

        this.petId = idCounter++;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.ownerName = ownerName;
        this.contactInfo = contactInfo;
        this.registrationDate = LocalDate.now();
    }

    public int getPetId() {
        return petId;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public byte getAge() {
        return age;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void printPetInfo() {
        System.out.println(
            "Pet ID: " + petId +
            " | Registered: " + registrationDate +
            " | Name: " + name +
            " | Breed: " + breed +
            " | Age: " + age +
            " | Owner: " + ownerName +
            " | Contact: " + contactInfo
        );
    }

    @Override
    public String toString() {
        return "Pet ID: " + petId +
               " | Name: " + name +
               " | Breed: " + breed +
               " | Age: " + age +
               " | Owner: " + ownerName;
    }
}