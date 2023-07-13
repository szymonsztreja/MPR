package client.test;

import client.Client;
import client.ClientRepository;
import client.ClientService;
import exception.ClientAlreadyExistsException;
import exception.ClientNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)

public class ClientServiceTest {
    @Mock
    Client client;
    @Mock
    ClientRepository clientRepository;

    @Test(expected = ClientAlreadyExistsException.class)
    public void shouldThrowClientAlreadyExistsException(){
        ClientService clientService = new ClientService(clientRepository);
        Client pam = new Client();
        pam.setId("Pam");

        Mockito.when(clientRepository.findClient("Pam")).thenReturn(pam);

        Client client = clientService.createNewClient(pam.getId());

        Assert.assertEquals(client.getId(), pam.getId());
    }

    @Test
    public void shouldCreateNewClientWithSpecifiedId(){
        ClientService clientService = new ClientService(clientRepository);
        Mockito.when(clientRepository.findClient("Pam")).thenReturn(null);
        Client client = clientService.createNewClient("Pam");
        System.out.println(client.getId() + " " +client.isActive());
    }

    @Test(expected = ClientNotFoundException.class)
    public void shouldThrowClientNotFoundException(){
        ClientService clientService = new ClientService(clientRepository);
        Mockito.when(clientRepository.findClient("Pam")).thenReturn(null);
        Client client = clientService.updateClientAccountId("Pam","Dwight");
    }

    @Test
    public void shouldUpdateIdForExistingClient(){
        ClientService clientService = new ClientService(clientRepository);
        Client pam = new Client();
        pam.setId("Pam");
        Mockito.when(clientRepository.findClient("Pam")).thenReturn(pam);
        Client client = clientService.updateClientAccountId("Pam","Dwight");
    }
}
