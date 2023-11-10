/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import adt.ListInterface; //VER 1.1 
import adt.SetInterface;
import entity.Member;
import entity.Room;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Lim Zhen Foo
 * Version control history
 * Initial                  Version                 Date                Description 
 * Lim Zhen Foo             1.1                  10/11/2023             Improve user interaction to be more user friendly  
 */
public class MemberMainteanance {

    public void memberModule(SetInterface<Member> member, SetInterface<Member> memSpkMan, SetInterface<Member> memSpkMly, SetInterface<Member> memSpkEng, ListInterface<Room> room) { //VER 1.1

        Scanner scanner = new Scanner(System.in);
        int number = 0;
        do {

            memberMenu();
            System.out.print("Please choose a number to proceed: ");
            number = scanner.nextInt();
            switch (number) {
                case 1:
                    addMember(member, room); //VER 1.1 
                    break;
                case 2:
                    int num = 0;
                    do {
                        setMenu();
                        System.out.print("Please choose a number to proceed: ");
                        num = scanner.nextInt();
                        switch (num) {
                            case 1:
                                int index = 0;
                                System.out.println("\n1. Add into member can speak Mandarin ");
                                System.out.println("2. Add into member can speak Malay ");
                                System.out.println("3. Add into member can speak English ");
                                System.out.print("Please choose a number to proceed: ");
                                index = scanner.nextInt();
                                switch (index) {
                                    case 1:
                                        addExistingMember(member, memSpkMan);
                                        break;
                                    case 2:
                                        addExistingMember(member, memSpkMly);
                                        break;
                                    case 3:
                                        addExistingMember(member, memSpkEng);
                                        break;
                                }

                                break;
                            case 2:
                                index = 0;
                                System.out.println("\n1. Remove the member from the set of member can speak Mandarin ");
                                System.out.println("2. Remove the member from the set of member can speak Malay ");
                                System.out.println("3. Remove the member from the set of member can speak English ");
                                System.out.print("Please choose a number to proceed: ");
                                index = scanner.nextInt();
                                int memberId = 0;
                                Member dummyMember = new Member(memberId, "dummy", 'M', "0", new Room(0), 1234);
                                switch (index) {
                                    case 1:
                                        System.out.println(memSpkMan);
                                        System.out.println("Please enter the member ID that you want to remove: ");
                                        memberId = scanner.nextInt();
                                        dummyMember.setMemberId(memberId);
                                        if (memSpkMan.remove(dummyMember)) {
                                            System.out.println("You have removed the member successfully");
                                        } else {
                                            System.out.println("The member doesn't exist in the set");
                                        }
                                        break;
                                    case 2:
                                        System.out.println(memSpkMly);
                                        System.out.println("Please enter the member ID that you want to remove: ");
                                        memberId = scanner.nextInt();
                                        dummyMember.setMemberId(memberId);
                                        if (memSpkMly.remove(dummyMember)) {
                                            System.out.println("You have removed the member successfully");
                                        } else {
                                            System.out.println("The member doesn't exist in the set");
                                        }
                                        break;
                                    case 3:
                                        System.out.println(memSpkEng);
                                        System.out.println("Please enter the member ID that you want to remove: ");
                                        memberId = scanner.nextInt();
                                        dummyMember.setMemberId(memberId);
                                        if (memSpkEng.remove(dummyMember)) {
                                            System.out.println("You have removed the member successfully");
                                        } else {
                                            System.out.println("The member doesn't exist in the set");
                                        }
                                        break;
                                }

                                break;
                            case 3:
                                index = 0;
                                System.out.println("\n1. View the members in the Mandarin set ");
                                System.out.println("2. View the members in the Malay set");
                                System.out.println("3. View the members in the English set");
                                System.out.print("Please choose a number to proceed: ");
                                index = scanner.nextInt();
                                switch (index) {
                                    case 1:
                                        System.out.println("The members in the Mandarin set");
                                        System.out.println(memSpkMan);
                                        break;
                                    case 2:
                                        System.out.println("The members in the Malay set");
                                        System.out.println(memSpkMly);
                                        break;
                                    case 3:
                                        System.out.println("The members in the English set");
                                        System.out.println(memSpkEng);
                                        break;
                                }
                                break;
                            case 4:
                                index = 0;
                                System.out.println("\n1. Mandarin set union Malay set");
                                System.out.println("2. Mandarin set union English set");
                                System.out.println("3. Malay set union English set");
                                System.out.println("4. Mandarin set union Malay set union English set");
                                System.out.print("Please choose a number to proceed: ");
                                index = scanner.nextInt();
                                switch (index) {
                                    case 1:
                                        System.out.println("Mandarin set union Malay set");
                                        System.out.println(memSpkMan.union(memSpkMly));
                                        break;
                                    case 2:
                                        System.out.println("Mandarin set union English set");
                                        System.out.println(memSpkMan.union(memSpkEng));
                                        break;
                                    case 3:
                                        System.out.println("Malay set union English set");
                                        System.out.println(memSpkMly.union(memSpkEng));
                                        break;
                                    case 4:
                                        System.out.println("Mandarin set union Malay set union English set");
                                        System.out.println(memSpkMan.union(memSpkMly).union(memSpkEng));
                                        break;
                                }
                                break;
                            case 5:
                                index = 0;
                                System.out.println("\n1. Mandarin set intersection with Malay set");
                                System.out.println("2. Mandarin set intersection with English set");
                                System.out.println("3. English set intersection with Malay set");
                                System.out.print("Please choose a number to proceed: ");
                                index = scanner.nextInt();
                                switch (index) {
                                    case 1:
                                        System.out.println("Mandarin set intersection with Malay set");
                                        System.out.println(memSpkMan.intersection(memSpkMly));
                                        break;
                                    case 2:
                                        System.out.println("Mandarin set intersection with English set");
                                        System.out.println(memSpkMan.intersection(memSpkEng));
                                        break;
                                    case 3:
                                        System.out.println("English set intersection with Malay set");
                                        System.out.println(memSpkEng.intersection(memSpkMly));
                                        break;
                                }
                                break;
                            case 6:
                                index = 0;
                                System.out.println("\n1. Mandarin set difference with Malay set");
                                System.out.println("2. Mandarin set difference with English set");
                                System.out.println("3. Malay set difference with Mandarin set");
                                System.out.println("4. Malay set difference with English set");
                                System.out.println("5. English set difference with Mandarin set");
                                System.out.println("6. English set difference with Malay set");
                                System.out.print("Please choose a number to proceed: ");
                                index = scanner.nextInt();
                                switch (index) {
                                    case 1:
                                        System.out.println("Mandarin set difference with Malay set");
                                        System.out.println(memSpkMan.difference(memSpkMly));
                                        break;
                                    case 2:
                                        System.out.println("Mandarin set difference with English set");
                                        System.out.println(memSpkMan.difference(memSpkEng));
                                        break;
                                    case 3:
                                        System.out.println("Malay set difference with Mandarin set");
                                        System.out.println(memSpkMly.difference(memSpkMan));
                                        break;
                                    case 4:
                                        System.out.println("Malay set difference with English set");
                                        System.out.println(memSpkMly.difference(memSpkEng));
                                        break;
                                    case 5:
                                        System.out.println("English set difference with Mandarin set");
                                        System.out.println(memSpkEng.difference(memSpkMan));
                                        break;
                                    case 6:
                                        System.out.println("English set difference with Malay set");
                                        System.out.println(memSpkEng.difference(memSpkMly));
                                        break;
                                }
                                break;
                            case 7:
                                System.out.println("MEMBERS ONLY SPEAK MANDARIN");
                                System.out.println(memSpkMan.difference(memSpkMly).difference(memSpkEng));
                                break;
                            case 8:
                                System.out.println("MEMBERS ONLY SPEAK MALAY");
                                System.out.println(memSpkMly.difference(memSpkMan).difference(memSpkEng));
                                break;
                            case 9:
                                System.out.println("MEMBERS ONLY SPEAK ENGLISH");
                                System.out.println(memSpkEng.difference(memSpkMan).difference(memSpkMly));
                                break;
                            case 10:
                                System.out.println("MEMBERS SPEAK ENGLISH AND MALAY ONLY");
                                System.out.println(memSpkEng.intersection(memSpkMly).difference(memSpkMan));
                                break;
                            case 11:
                                System.out.println("MEMBERS SPEAK ENGLISH AND MANDARIN ONLY");
                                System.out.println(memSpkEng.intersection(memSpkMan).difference(memSpkMly));
                                break;
                            case 12:
                                System.out.println("MEMBERS SPEAK MALAY AND MANDARIN ONLY");
                                System.out.println(memSpkMly.intersection(memSpkMan).difference(memSpkEng));
                                break;
                            case 13:
                                System.out.println("MEMBERS CAN SPEAK ALL LANGUAGES");
                                System.out.println(memSpkEng.intersection(memSpkMan).intersection(memSpkMly));
                                break;
                            case 14:
                                System.out.println("MEMBERS SPEAK ENGLISH AND/OR MANDARIN");
                                System.out.println("\n" + memSpkEng.union(memSpkMan));
                                break;
                            case 15:
                                break;
                            default:
                                System.out.println("Invalid input");
                                break;
                        }

                    } while (num != 15);
                    break;
                case 3:
                    System.out.println(member);
                    break;
                case 4:
                    System.out.println(member);
                    System.out.print("Please insert the member id that you want to UPDATE his details: ");
                    int id = scanner.nextInt();
                    edit(id, member, memSpkMan, memSpkMly, memSpkEng);
                    break;
                case 5:
                    System.out.println(member);
                    System.out.print("Please insert the member id that you want to DELETE: ");
                    id = scanner.nextInt();
                    Member dummyMember = new Member(id, "dummy", 'M', "0", new Room(0), 1111);
                    if (member.remove(dummyMember)) {
                        System.out.println("You have removed the member successfully");
                    } else {
                        System.out.println("The member doesn't exist in the system");
                    }
                    memSpkMan.remove(dummyMember);
                    memSpkMly.remove(dummyMember);
                    memSpkEng.remove(dummyMember);
                    break;
                case 6:
                    generateReport(member, memSpkMan, memSpkMly, memSpkEng);
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        } while (number != 7);

    }

    public static void addMember(SetInterface member, ListInterface<Room> room) { //VER 1.1 
        Scanner scanner = new Scanner(System.in);
        
        String name = "";
        char gender = ' ';
        String contactNo = "";
        int password = 0;
        int roomId = 0;
        boolean input = true;
        //input name
        do {
            try {
                System.out.print("\nName: ");
                name = scanner.nextLine();
                input = false;
            } catch (Exception ex) {
                System.out.print("\nIncorrect input: string required");
                scanner.nextLine();
            }

        } while (input);
        //input gender
        input = true;
        do {
            try {
                
                System.out.print("\nGender(M/F): ");
                gender = scanner.next().charAt(0);
                //VER 1.1 [S]
                while(gender != 'M' && gender != 'F' && gender != 'm' && gender != 'f'){
                    System.out.print("Wrong input, only 'M/m' or 'F/f'");
                    System.out.print("\nGender(M/F): ");
                    gender = scanner.next().charAt(0);
                }
                //VER 1.1 [E] 
                
                input = false;
            } catch (Exception ex) {
                System.out.print("\nIncorrect input: char required");
                scanner.next().charAt(0);
            }

        } while (input);
        //input contact no
        scanner.nextLine();
        input = true;
        do {
            try {
                System.out.print("\nContact no: ");
                contactNo = scanner.nextLine();
                input = false;
            } catch (Exception ex) {
                System.out.print("\nIncorrect input: String required");
                scanner.nextLong();
            }

        } while (input);
        //input room
        input = true;
        do {

            //VER 1.1 [S]
            System.out.print("\nExisting Room\n");
            System.out.print(room);
            System.out.print("\nRoom ID: ");
            while (!scanner.hasNextInt()) {
                String input_tmp = scanner.next();
                System.out.println("Invalid input. Please enter a valid integer.");
                System.out.print("Room ID: ");
            }
            roomId = scanner.nextInt();
            
            if (roomId < 1001 || roomId > 1008) {
                System.out.println("\nThe room id doesn't exist\n");
                input = true;
            } else {
                input = false;
            }
            //VER 1.1 [E]
        } while (input);

        input = true;
        do {
            try {
                System.out.print("\nPassword: ");
                password = scanner.nextInt();
                input = false;
            } catch (Exception ex) {
                System.out.print("\nIncorrect input: long required");
                scanner.nextInt();
            }

        } while (input);

        if (member.add(new Member(name, gender, contactNo, new Room(roomId), password))) {
            System.out.println("You have added the new member successfully!");
        } else {
            System.out.println("The member has existed in the system");
        }

    }

    public static void addExistingMember(SetInterface existingMember, SetInterface memberSet) {
        Scanner scanner = new Scanner(System.in);

        Iterator<Member> iterator = existingMember.getIterator();
        int memberId = 0;
        boolean input = true;
        do {
            //VER 1.1 [S]
            System.out.println("\nExisting memeber");
            System.out.println(existingMember);
            //VER 1.1 [E]
            try {
                System.out.print("\nID: ");
                memberId = scanner.nextInt();
                input = false;
            } catch (Exception ex) {
                System.out.print("\nIncorrect input: int required");
                scanner.nextInt();
            }

        } while (input);
        Member newMember = new Member(memberId, "dummy", 'F', "", new Room(0), 0);
        boolean found = false;
        while (iterator.hasNext() && !found) {
            newMember = iterator.next();
            if (newMember.getMemberId() == memberId) {
                found = true;
                break;
            }

        }
        if (found) {
            if (memberSet.add(new Member(memberId, newMember.getName(), newMember.getGender(), newMember.getContactNo(), new Room(newMember.getRoom().getRoomID()), newMember.getPassword()))) {
                System.out.println("You have assigned successfully");
            } else {
                System.out.println("The member has existed in the set");
            }
        } else {
            System.out.println("The member doesn't exist in the system");
        }
    }

    public static void edit(int memberId, SetInterface member, SetInterface memSpkMan, SetInterface memSpkMly, SetInterface memSpkEng) {
        //member.contains(memberId);
        Member newMember = new Member(memberId, "dummy", 'F', "", new Room(0), 0);
        Iterator<Member> iterator = member.getIterator();

        boolean found = false;
        while (iterator.hasNext() && !found) {
            newMember = iterator.next();
            if (newMember.getMemberId() == memberId) {
                found = true;
                break;
            }

        }
        if (found) {
            //Node curentnode = firstnodel
            Member currentMember = newMember;
            String name = "";
            char gender = ' ';
            String contactNo = "";
            int password = 0;
            Scanner scanner = new Scanner(System.in);
            int roomId = 0;
            boolean input = true;

            do {
                try {
                    System.out.print("\nUpdate name: ");
                    name = scanner.nextLine();
                    input = false;
                } catch (Exception ex) {
                    System.out.print("\nIncorrect input: string required");
                    scanner.nextLine();
                }

            } while (input);
            //input gender
            input = true;
            do {
                try {
                    System.out.print("\nUpdate gender(M/F): ");

                    gender = scanner.next().charAt(0);
                    input = false;
                } catch (Exception ex) {
                    System.out.print("\nIncorrect input: char required");
                    scanner.next().charAt(0);
                }

            } while (input);
            //input contact no
            scanner.nextLine(); //catch space
            input = true;
            do {
                try {
                    System.out.print("\nUpdate contact no: ");
                    contactNo = scanner.nextLine();
                    input = false;
                } catch (Exception ex) {
                    System.out.print("\nIncorrect input: String required");
                    scanner.nextLong();
                }

            } while (input);
            //input password
            input = true;
            do {
                try {
                    System.out.print("\nPassword: ");
                    password = scanner.nextInt();
                    input = false;
                } catch (Exception ex) {
                    System.out.print("\nIncorrect input: int required");
                    scanner.nextInt();
                }

            } while (input);
            //input room
            input = true;
        do {
            
                System.out.print("\nRoom ID: ");
                roomId = scanner.nextInt();

                if(roomId<1001 || roomId>1008){
                    System.out.println("The room id doesn't exist");
                    input = true;
                }
                else{
                    input = false;
                }
            

        } while (input);
            currentMember.setName(name);
            currentMember.setGender(gender);
            currentMember.setContactNo(contactNo);
            currentMember.setPassword(password);
            currentMember.setRoomId(roomId);
            //check whether need to update memSpkMan set or not
            newMember = new Member(memberId, "dummy", 'F', "", new Room(0), 0);
            if (memSpkMan.contains(newMember)) {
                Iterator<Member> iteratorSet1 = memSpkMan.getIterator();
                found = false;
                while (iteratorSet1.hasNext() && !found) {
                    if (newMember.getMemberId() == memberId) {
                        found = true;
                        break;
                    }
                    newMember = iterator.next();
                }
                if (found) {
                    memSpkMan.remove(newMember);
                    memSpkMan.add(new Member(memberId, name, gender, contactNo, new Room(roomId), password));

                }
            }
            //check whether need to update memSpkMly set or not
            if (memSpkMly.contains(newMember)) {
                Iterator<Member> iteratorSet2 = memSpkMly.getIterator();
                found = false;
                while (iteratorSet2.hasNext() && !found) {
                    if (newMember.getMemberId() == memberId) {
                        found = true;
                        break;
                    }
                    newMember = iterator.next();
                }
                if (found) {
                    memSpkMly.remove(newMember);
                    memSpkMly.add(new Member(memberId, name, gender, contactNo, new Room(roomId), password));

                }
            }
            //check whether need to update memSpkMly set or not 
            if (memSpkEng.contains(newMember)) {
                Iterator<Member> iteratorSet2 = memSpkEng.getIterator();
                found = false;
                while (iteratorSet2.hasNext() && !found) {
                    if (newMember.getMemberId() == memberId) {
                        found = true;
                        break;
                    }
                    newMember = iterator.next();
                }
                if (found) {
                    memSpkEng.remove(newMember);
                    memSpkEng.add(new Member(memberId, name, gender, contactNo, new Room(roomId), password));

                }
            }
            System.out.println("You have updated the member details successfully");
        } else {
            System.out.println("Sorry, the member doesn't exist in the system");
        }
    }

    public static void generateReport(SetInterface member, SetInterface memSpkMan, SetInterface memSpkMly, SetInterface memSpkEng) {

        Iterator<Member> iterator = member.getIterator();
        Iterator<Member> iteratorSet1 = memSpkMan.getIterator();
        Iterator<Member> iteratorSet2 = memSpkMly.getIterator();
        Iterator<Member> iteratorSet3 = memSpkEng.getIterator();
        System.out.println("\t\t\tAll member in the system");
        System.out.println("MemberID\tName\t\tGender\t\tContactNo\tRoom\tPassword");
        while (iterator.hasNext()) {
            Member dummyMember = iterator.next();
            System.out.printf("%-8d\t"
                    + "%-10s\t"
                    + "%6s\t"
                    + "%17s\t"
                    + "%4d\t"
                    + "%8d\n",
                    dummyMember.getMemberId(),
                    dummyMember.getName(),
                    dummyMember.getGender(),
                    dummyMember.getContactNo(),
                    dummyMember.getRoom().getRoomID(),
                    dummyMember.getPassword());

        }
        System.out.println("\n\t\t\tAll member that speak Mandarin");
        System.out.println("MemberID\tName\t\tGender\t\tContactNo\tRoom\tPassword");
        while (iteratorSet1.hasNext()) {
            Member dummyMember = iteratorSet1.next();
            System.out.printf("%-8d\t"
                    + "%-10s\t"
                    + "%6s\t"
                    + "%17s\t"
                    + "%4d\t"
                    + "%8d\n",
                    dummyMember.getMemberId(),
                    dummyMember.getName(),
                    dummyMember.getGender(),
                    dummyMember.getContactNo(),
                    dummyMember.getRoom().getRoomID(),
                    dummyMember.getPassword());
        }
        System.out.println("\n\t\t\tAll member that speak Malay");
        System.out.println("MemberID\tName\t\tGender\t\tContactNo\tRoom\tPassword");
        while (iteratorSet2.hasNext()) {
            Member dummyMember = iteratorSet2.next();
            System.out.printf("%-8d\t"
                    + "%-10s\t"
                    + "%6s\t"
                    + "%17s\t"
                    + "%4d\t"
                    + "%8d\n",
                    dummyMember.getMemberId(),
                    dummyMember.getName(),
                    dummyMember.getGender(),
                    dummyMember.getContactNo(),
                    dummyMember.getRoom().getRoomID(),
                    dummyMember.getPassword());
        }
        System.out.println("\n\t\t\tAll member that speak English");
        System.out.println("MemberID\tName\t\tGender\t\tContactNo\tRoom\tPassword");
        while (iteratorSet3.hasNext()) {
            Member dummyMember = iteratorSet3.next();
            System.out.printf("%-8d\t"
                    + "%-10s\t"
                    + "%6s\t"
                    + "%17s\t"
                    + "%4d\t"
                    + "%8d\n",
                    dummyMember.getMemberId(),
                    dummyMember.getName(),
                    dummyMember.getGender(),
                    dummyMember.getContactNo(),
                    dummyMember.getRoom().getRoomID(),
                    dummyMember.getPassword());
        }
    }

    public static void setMenu() {
        System.out.println("\n1. Assign the member into the set");
        System.out.println("2. Remove the member from the set");
        System.out.println("3. View the member set");
        System.out.println("4. Union set");
        System.out.println("5. Intersection set");
        System.out.println("6. Difference set");
        System.out.println("7. MEMBERS ONLY SPEAK MANDARIN");
        System.out.println("8. MEMBERS ONLY SPEAK MALAY");
        System.out.println("9. MEMBERS ONLY SPEAK ENGLISH");
        System.out.println("10. MEMBERS SPEAK ENGLISH AND MALAY ONLY");
        System.out.println("11. MEMBERS SPEAK ENGLISH AND MANDARIN ONLY");
        System.out.println("12. MEMBERS SPEAK MALAY AND MANDARIN ONLY");
        System.out.println("13. MEMBERS CAN SPEAK ALL LANGUAGES");
        System.out.println("14. MEMBERS SPEAK ENGLISH AND/OR MANDARIN");
        System.out.println("15. Exit");

    }

    public static void memberMenu() {
        System.out.println("\n1. Add new member");
        System.out.println("2. Manipulate the member set");
        System.out.println("3. View existing members details");
        System.out.println("4. Update existing members details");
        System.out.println("5. Remove existing member");
        System.out.println("6. Generate report");
        System.out.println("7. Exit");
    }

    public void createMember(SetInterface member) {

        member.add(new Member("Zai", 'M', "014236789", new Room(1001), 1111)); //1000
        member.add(new Member("Nurul", 'F', "0169234857", new Room(1002), 2222)); //1001
        member.add(new Member("Zahir", 'M', "0132456789", new Room(1003), 3333));//1002
        member.add(new Member("Nur", 'F', "0198274635", new Room(1001), 4444));//1003
        member.add(new Member("Kather", 'M', "0189234756", new Room(1002), 5555));//1004
        member.add(new Member("Yang", 'M', "0152346789", new Room(1004), 6666));//1005
        member.add(new Member("Ko", 'M', "0142398576", new Room(1005), 7777));//1006
        member.add(new Member("Xu", 'F', "0123948576", new Room(1008), 8888));//1007
        member.add(new Member("Sara", 'M', "0169234857", new Room(1004), 9999));//1008
        member.add(new Member("Hani", 'F', "01092348576", new Room(1003), 1000));//1009

    }

    public void initMember(SetInterface memSpkMan, SetInterface memSpkMly, SetInterface memSpkEng) {

        memSpkMan.add(new Member(1005, "Yang", 'M', "0152346789", new Room(1004), 6666));
        memSpkMan.add(new Member(1006, "Ko", 'M', "0142398576", new Room(1005), 7777));
        memSpkMan.add(new Member(1007, "Xu", 'F', "0123948576", new Room(1008), 8888));
        memSpkMan.add(new Member(1009, "Hani", 'F', "01092348576", new Room(1003), 1000));//

        memSpkMly.add(new Member(1000, "Zai", 'M', "014236789", new Room(1001), 1111));
        memSpkMly.add(new Member(1001, "Nurul", 'F', "0169234857", new Room(1002), 2222));
        memSpkMly.add(new Member(1002, "Zahir", 'M', "0132456789", new Room(1003), 3333));
        memSpkMly.add(new Member(1003, "Nur", 'F', "0198274635", new Room(1001), 4444));
        memSpkMly.add(new Member(1004, "Kather", 'M', "0189234756", new Room(1002), 5555));
        memSpkMly.add(new Member(1005, "Yang", 'M', "0152346789", new Room(1004), 6666));
        memSpkMly.add(new Member(1008, "Sara", 'M', "0169234857", new Room(1004), 9999));

        memSpkEng.add(new Member(1008, "Sara", 'M', "0169234857", new Room(1004), 9999));
        memSpkEng.add(new Member(1005, "Yang", 'M', "0152346789", new Room(1004), 6666));
        memSpkEng.add(new Member(1006, "Ko", 'M', "0142398576", new Room(1005), 7777));
        memSpkEng.add(new Member(1007, "Xu", 'F', "0123948576", new Room(1008), 8888));
        memSpkEng.add(new Member(1002, "Zahir", 'M', "0132456789", new Room(1003), 3333));
    }

}
