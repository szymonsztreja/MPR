package car.test;

import car.Car;
import car.CarCreator;
import car.CarService;
import client.Client;
import client.ClientRepository;
import exception.PaymentException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import payment.Payment;
import payment.PaymentRepository;

@RunWith(MockitoJUnitRunner.class)

public class CarServiceTest {
    @Mock
    Payment payment;

    @Mock
    CarCreator carCreator;

    @Mock
    ClientRepository clientRepository;

    @Mock
    PaymentRepository paymentRepository;

    @Test(expected = PaymentException.class)
    public void shouldThrowExceptionWhenPaymentIsZero(){
        Mockito.when(payment.getAmount()).thenReturn(0);
        CarService carService = new CarService(carCreator, clientRepository, paymentRepository);
        carService.savePayment(payment);
    }

    @Test
    public void shouldRegisterClientWithACar(){

        CarService carService = new CarService(carCreator, clientRepository, paymentRepository);
        Car audi = new Car();
        audi.setMake("Audi");
        audi.setColor("Blue");
        audi.setPlate("G0 WIADRO");

        Mockito.when(carCreator.createCar("Audi", "Blue", "G0 WIADRO"))
                .thenReturn(audi);

        Client pam = new Client();
        pam.setId("Pam");

        Mockito.when(clientRepository.findClient("Pam")).thenReturn(pam);

        Client client = carService.registerClientCar("Pam", "Audi", "Blue",
                "G0 WIADRO");

        Assert.assertEquals(pam.getId(), client.getId());
        Assert.assertEquals(audi.getPlate(), client.getCar().getPlate());
    }
}
