package ee.alex.timepass.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ee.alex.timepass.dto.PaymentDTO;
import ee.alex.timepass.dto.PaymentRequestDTO;
import ee.alex.timepass.service.PaymentService;
import lombok.RequiredArgsConstructor;

@Controller
@EnableAutoConfiguration
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping()
    public String getAllPayments(Model model) {

        model.addAttribute("paymentList", getPaymentList());
        model.addAttribute("payment", new PaymentDTO());

        return "payment_add";
    }

    @PostMapping()
    public String postRegisterForm(@Valid @ModelAttribute("payment") PaymentRequestDTO paymentRequestDTO, BindingResult bindingResult, Model model, Locale locale) {

        Boolean registered = false;
        try {

            if (bindingResult.hasErrors()) {
                // hasError = true;
            }

            paymentService.addPayment(paymentRequestDTO);
            registered = true;

        } catch (Exception ex) {
            registered = false;
        }

        model.addAttribute("registered", registered);
        model.addAttribute("paymentList", getPaymentList());
        model.addAttribute("payment", new PaymentDTO());

        return "payment_add";
    }

    private List<PaymentDTO> getPaymentList() {
        List<PaymentDTO> paymentList = paymentService.getAll();
        Collections.sort(paymentList, new Comparator<PaymentDTO>() {
            @Override
            public int compare(PaymentDTO lhs, PaymentDTO rhs) {
                return lhs.getId() > rhs.getId() ? -1 : (lhs.getId() < rhs.getId()) ? 1 : 0;
            }
        });
        return paymentList;
    }
}
