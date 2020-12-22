package com.netcracker.edu.backend;

import com.netcracker.edu.backend.entity.User;
import com.netcracker.edu.backend.service.BillingAccountService;
import com.netcracker.edu.backend.service.UserService;
import com.netcracker.edu.backend.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Debiter {
    @Autowired
    private UserService userService;

    @Autowired
    private WalletService walletService;

    @Autowired
    private BillingAccountService billingAccountService;

    public Debiter() {
    }

    //    @Autowired
    public Debiter(UserService userService) {
        this.userService = userService;
    }

    @Scheduled(fixedDelay = 5000)
    public void debit() {

        List<User> users = userService.findAll();

//        users.forEach(user -> {
//            long summa = 0;
//            for(Serv serv : user.getServs()){
//                summa += serv.getPrice();
//            }
//            if(user.getBa_Id().getWallet().getAmount()< summa){
//                user.getBa_Id().setActive(false);
//            }
//            else if(user.getBa_Id().getWallet().getAmount()>summa){
//                user.getBa_Id().setActive(true);
//                user.getBa_Id().getWallet().setAmount(user.getBa_Id().getWallet().getAmount() - summa);
//            }
//            walletService.save(user.getBa_Id().getWallet());
//            billingAccountService.save(user.getBa_Id());
//
//        });
//        List<Serv> servs = servService.findAll();
//        users.forEach(castomer -> {
//            servs.forEach(serv -> serv.getUsers().forEach(customer1 -> {
//                        System.out.println(customer1.getFirstName());
//                long sum = 0;
//                sum += serv.getPrice();
//                        System.out.println(sum);
//                        if (customer1.getBa_Id().getWallet().getAmount() < serv.getPrice()) {
//                            customer1.getBa_Id().setActive(false);
//                            System.out.println("eror");
//                        } else if(customer1.getBa_Id().getWallet().getAmount() >= serv.getPrice()) {
//                            servs.forEach(serv1 -> {
//                            serv1.getUsers().forEach(customer2 -> {customer2.getBa_Id().getWallet()
//                                    .setAmount(customer2.getBa_Id().getWallet().getAmount() - serv1.getPrice());
//                            customer2.getBa_Id().setActive(true);});
//
//                            servService.save(serv1);
//                        });}
////                System.out.println(sum);
//                    }
//            ));
//        });
    }
}

