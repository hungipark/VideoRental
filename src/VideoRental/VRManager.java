package VideoRental;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class VRManager {

    private Scanner scanner;
    private List<Customer> customers = new ArrayList<Customer>() ;

    private List<Video> videos = new ArrayList<Video>() ;

    public VRManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void clearRentals() {
        System.out.println("Enter customer name: ");
        String customerName = scanner.next();

        Customer foundCustomer = getCustomer(customerName);

        if (foundCustomer == null) {
            System.out.println("No customer found");
        } else {
            printCustomerInfo(foundCustomer);

            foundCustomer.clearRentals();
        }
    }

    private void printCustomerInfo(Customer foundCustomer) {
        System.out.println("Name: " + foundCustomer.getName() +
                "\tRentals: " + foundCustomer.getRentals().size());
        for (Rental rental : foundCustomer.getRentals()) {
            System.out.print("\tTitle: " + rental.getVideo().getTitle() + " ");
            System.out.print("\tPrice Code: " + rental.getVideo().getPriceCode());
        }
    }

    public void returnVideo() {
        System.out.println("Enter customer name: ");
        String customerName = scanner.next();

        Customer foundCustomer = getCustomer(customerName);
        if (foundCustomer == null) return;

        System.out.println("Enter video title to return: ");
        String videoTitle = scanner.next();

        List<Rental> customerRentals = foundCustomer.getRentals();
        for (Rental rental : customerRentals) {
            if (rental.getVideo().getTitle().equals(videoTitle) && rental.getVideo().isRented()) {
                rental.returnVideo();
                break;
            }
        }
    }

    private Customer getCustomer(String customerName) {
        Customer foundCustomer = null;
        for (Customer customer : customers) {
            if (customer.getName().equals(customerName)) {
                foundCustomer = customer;
                break;
            }
        }
        return foundCustomer;
    }

    void init() {
        Customer james = new Customer("James");
        Customer brown = new Customer("Brown");
        customers.add(james);
        customers.add(brown);

        Video v1 = VideoFactory.create("v1", VideoType.CD, Video.REGULAR, new Date());
        Video v2 = VideoFactory.create("v2", VideoType.DVD, Video.NEW_RELEASE, new Date());
        videos.add(v1);
        videos.add(v2);

        Rental r1 = new Rental(v1);
        Rental r2 = new Rental(v2);

        james.addRental(r1);
        james.addRental(r2);
    }

    public void listVideos() {
        System.out.println("List of videos");

        for (Video video : videos) {
            System.out.println("Price code: " + video.getPriceCode() + "\tTitle: " + video.getTitle());
        }
        System.out.println("End of list");
    }

    public void listCustomers() {
        System.out.println("List of customers");
        for (Customer customer : customers) {
            printCustomerInfo(customer);
        }
        System.out.println("End of list");
    }

    public void getCustomerReport() {
        System.out.println("Enter customer name: ");
        String customerName = scanner.next();

        Customer foundCustomer = getCustomer(customerName);

        if (foundCustomer == null) {
            System.out.println("No customer found");
        } else {
            String result = foundCustomer.getReport();
            System.out.println(result);
        }
    }

    public void rentVideo() {
        System.out.println("Enter customer name: ");
        String customerName = scanner.next();

        Customer foundCustomer = getCustomer(customerName);

        if (foundCustomer == null) return;

        System.out.println("Enter video title to rent: ");
        String videoTitle = scanner.next();

        Video foundVideo = getVideo(videoTitle, false);

        if (foundVideo == null) return;

        Rental rental = new Rental(foundVideo);
        foundVideo.setRented(true);

        foundCustomer.addRental(rental);
    }

    private Video getVideo(String videoTitle, boolean isRented) {
        Video foundVideo = null;
        for (Video video : videos) {
            if (video.getTitle().equals(videoTitle) && video.isRented() == isRented) {
                foundVideo = video;
                break;
            }
        }
        return foundVideo;
    }

    public void registerCustomer() {
        System.out.println("Enter customer name: ");
        String name = scanner.next();
        Customer customer = new Customer(name);
        customers.add(customer);
    }

    public void registerVideo() {
        System.out.println("Enter video title to register: ");
        String title = scanner.next();

        System.out.println("Enter video type( 1 for VHD, 2 for CD, 3 for DVD ):");
        int videoType = scanner.nextInt();

        System.out.println("Enter price code( 1 for Regular, 2 for New Release ):");
        int priceCode = scanner.nextInt();

        Date registeredDate = new Date();
        Video video = VideoFactory.create(title, VideoType.getValue(videoType), priceCode, registeredDate);
        videos.add(video);
    }
}