package  com.ird.faa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import java.util.*;
import java.util.stream.Stream;

import com.ird.faa.security.common.AuthoritiesConstants;
import com.ird.faa.security.bean.User;
import com.ird.faa.security.bean.Permission;
import com.ird.faa.security.bean.Role;
import com.ird.faa.security.service.facade.UserService;
import com.ird.faa.security.service.facade.RoleService;
import com.ird.faa.bean.Chercheur;


@SpringBootApplication
public class FaaApplication {
public static ConfigurableApplicationContext ctx;

public static void main(String[] args) {
ctx=SpringApplication.run(FaaApplication.class, args);
}

public static ConfigurableApplicationContext getCtx() {
return ctx;
}

@Bean
public CommandLineRunner demo(UserService userService, RoleService roleService
) {
return (args) -> {
if(true){
    Map<String,String> etats=new HashMap<>();
    etats.put("Initialisé","initialise");
    etats.put("En cours","encours");
    etats.put("Terminé","termine");


    // Role admin
        User userForAdmin = new User("admin");

    Role roleForAdmin = new Role();
    roleForAdmin.setAuthority(AuthoritiesConstants.ADMIN);
    List<Permission> permissionsForAdmin = new ArrayList<>();
    addPermissionForAdmin(permissionsForAdmin);
    roleForAdmin.setPermissions(permissionsForAdmin);
    if(userForAdmin.getRoles()==null)
    userForAdmin.setRoles(new ArrayList<>());

    userForAdmin.getRoles().add(roleForAdmin);
    userService.save(userForAdmin);


    // Role chercheur
        Chercheur userForChercheur = new Chercheur("chercheur");

    Role roleForChercheur = new Role();
    roleForChercheur.setAuthority(AuthoritiesConstants.CHERCHEUR);
    List<Permission> permissionsForChercheur = new ArrayList<>();
    addPermissionForChercheur(permissionsForChercheur);
    roleForChercheur.setPermissions(permissionsForChercheur);
    if(userForChercheur.getRoles()==null)
    userForChercheur.setRoles(new ArrayList<>());

    userForChercheur.getRoles().add(roleForChercheur);
    userService.save(userForChercheur);


    // Role gestionnaire
        User userForGestionnaire = new User("gestionnaire");

    Role roleForGestionnaire = new Role();
    roleForGestionnaire.setAuthority(AuthoritiesConstants.GESTIONNAIRE);
    List<Permission> permissionsForGestionnaire = new ArrayList<>();
    addPermissionForGestionnaire(permissionsForGestionnaire);
    roleForGestionnaire.setPermissions(permissionsForGestionnaire);
    if(userForGestionnaire.getRoles()==null)
    userForGestionnaire.setRoles(new ArrayList<>());

    userForGestionnaire.getRoles().add(roleForGestionnaire);
    userService.save(userForGestionnaire);


    // Role agent
        User userForAgent = new User("agent");

    Role roleForAgent = new Role();
    roleForAgent.setAuthority(AuthoritiesConstants.AGENT);
    List<Permission> permissionsForAgent = new ArrayList<>();
    addPermissionForAgent(permissionsForAgent);
    roleForAgent.setPermissions(permissionsForAgent);
    if(userForAgent.getRoles()==null)
    userForAgent.setRoles(new ArrayList<>());

    userForAgent.getRoles().add(roleForAgent);
    userService.save(userForAgent);
    }
        };
        }

        private static void addPermissionForAdmin(List
        <Permission> permissions){
                permissions.add(new Permission("Devise.edit"));
                permissions.add(new Permission("Devise.list"));
                permissions.add(new Permission("Devise.view"));
                permissions.add(new Permission("Devise.add"));
                permissions.add(new Permission("Devise.delete"));
                permissions.add(new Permission("TypeClient.edit"));
                permissions.add(new Permission("TypeClient.list"));
                permissions.add(new Permission("TypeClient.view"));
                permissions.add(new Permission("TypeClient.add"));
                permissions.add(new Permission("TypeClient.delete"));
                permissions.add(new Permission("Gestionnaire.edit"));
                permissions.add(new Permission("Gestionnaire.list"));
                permissions.add(new Permission("Gestionnaire.view"));
                permissions.add(new Permission("Gestionnaire.add"));
                permissions.add(new Permission("Gestionnaire.delete"));
                permissions.add(new Permission("TypeSinistre.edit"));
                permissions.add(new Permission("TypeSinistre.list"));
                permissions.add(new Permission("TypeSinistre.view"));
                permissions.add(new Permission("TypeSinistre.add"));
                permissions.add(new Permission("TypeSinistre.delete"));
                permissions.add(new Permission("TypeVehicule.edit"));
                permissions.add(new Permission("TypeVehicule.list"));
                permissions.add(new Permission("TypeVehicule.view"));
                permissions.add(new Permission("TypeVehicule.add"));
                permissions.add(new Permission("TypeVehicule.delete"));
                permissions.add(new Permission("Vehicule.edit"));
                permissions.add(new Permission("Vehicule.list"));
                permissions.add(new Permission("Vehicule.view"));
                permissions.add(new Permission("Vehicule.add"));
                permissions.add(new Permission("Vehicule.delete"));
                permissions.add(new Permission("Carburant.edit"));
                permissions.add(new Permission("Carburant.list"));
                permissions.add(new Permission("Carburant.view"));
                permissions.add(new Permission("Carburant.add"));
                permissions.add(new Permission("Carburant.delete"));
                permissions.add(new Permission("Garantie.edit"));
                permissions.add(new Permission("Garantie.list"));
                permissions.add(new Permission("Garantie.view"));
                permissions.add(new Permission("Garantie.add"));
                permissions.add(new Permission("Garantie.delete"));
                permissions.add(new Permission("ContratGarantie.edit"));
                permissions.add(new Permission("ContratGarantie.list"));
                permissions.add(new Permission("ContratGarantie.view"));
                permissions.add(new Permission("ContratGarantie.add"));
                permissions.add(new Permission("ContratGarantie.delete"));
                permissions.add(new Permission("ClientSininstre.edit"));
                permissions.add(new Permission("ClientSininstre.list"));
                permissions.add(new Permission("ClientSininstre.view"));
                permissions.add(new Permission("ClientSininstre.add"));
                permissions.add(new Permission("ClientSininstre.delete"));
                permissions.add(new Permission("Client.edit"));
                permissions.add(new Permission("Client.list"));
                permissions.add(new Permission("Client.view"));
                permissions.add(new Permission("Client.add"));
                permissions.add(new Permission("Client.delete"));
                permissions.add(new Permission("NatureContrat.edit"));
                permissions.add(new Permission("NatureContrat.list"));
                permissions.add(new Permission("NatureContrat.view"));
                permissions.add(new Permission("NatureContrat.add"));
                permissions.add(new Permission("NatureContrat.delete"));
                permissions.add(new Permission("Sinistre.edit"));
                permissions.add(new Permission("Sinistre.list"));
                permissions.add(new Permission("Sinistre.view"));
                permissions.add(new Permission("Sinistre.add"));
                permissions.add(new Permission("Sinistre.delete"));
                permissions.add(new Permission("QuittanceIndemniser.edit"));
                permissions.add(new Permission("QuittanceIndemniser.list"));
                permissions.add(new Permission("QuittanceIndemniser.view"));
                permissions.add(new Permission("QuittanceIndemniser.add"));
                permissions.add(new Permission("QuittanceIndemniser.delete"));
                permissions.add(new Permission("Admin.edit"));
                permissions.add(new Permission("Admin.list"));
                permissions.add(new Permission("Admin.view"));
                permissions.add(new Permission("Admin.add"));
                permissions.add(new Permission("Admin.delete"));
                permissions.add(new Permission("QuittancePrime.edit"));
                permissions.add(new Permission("QuittancePrime.list"));
                permissions.add(new Permission("QuittancePrime.view"));
                permissions.add(new Permission("QuittancePrime.add"));
                permissions.add(new Permission("QuittancePrime.delete"));
                permissions.add(new Permission("Agent.edit"));
                permissions.add(new Permission("Agent.list"));
                permissions.add(new Permission("Agent.view"));
                permissions.add(new Permission("Agent.add"));
                permissions.add(new Permission("Agent.delete"));
                permissions.add(new Permission("Chercheur.edit"));
                permissions.add(new Permission("Chercheur.list"));
                permissions.add(new Permission("Chercheur.view"));
                permissions.add(new Permission("Chercheur.add"));
                permissions.add(new Permission("Chercheur.delete"));
                permissions.add(new Permission("Contrat.edit"));
                permissions.add(new Permission("Contrat.list"));
                permissions.add(new Permission("Contrat.view"));
                permissions.add(new Permission("Contrat.add"));
                permissions.add(new Permission("Contrat.delete"));
                permissions.add(new Permission("Marque.edit"));
                permissions.add(new Permission("Marque.list"));
                permissions.add(new Permission("Marque.view"));
                permissions.add(new Permission("Marque.add"));
                permissions.add(new Permission("Marque.delete"));
            }
        private static void addPermissionForChercheur(List
        <Permission> permissions){
                permissions.add(new Permission("Devise.edit"));
                permissions.add(new Permission("Devise.list"));
                permissions.add(new Permission("Devise.view"));
                permissions.add(new Permission("Devise.add"));
                permissions.add(new Permission("Devise.delete"));
                permissions.add(new Permission("TypeClient.edit"));
                permissions.add(new Permission("TypeClient.list"));
                permissions.add(new Permission("TypeClient.view"));
                permissions.add(new Permission("TypeClient.add"));
                permissions.add(new Permission("TypeClient.delete"));
                permissions.add(new Permission("Gestionnaire.edit"));
                permissions.add(new Permission("Gestionnaire.list"));
                permissions.add(new Permission("Gestionnaire.view"));
                permissions.add(new Permission("Gestionnaire.add"));
                permissions.add(new Permission("Gestionnaire.delete"));
                permissions.add(new Permission("TypeSinistre.edit"));
                permissions.add(new Permission("TypeSinistre.list"));
                permissions.add(new Permission("TypeSinistre.view"));
                permissions.add(new Permission("TypeSinistre.add"));
                permissions.add(new Permission("TypeSinistre.delete"));
                permissions.add(new Permission("TypeVehicule.edit"));
                permissions.add(new Permission("TypeVehicule.list"));
                permissions.add(new Permission("TypeVehicule.view"));
                permissions.add(new Permission("TypeVehicule.add"));
                permissions.add(new Permission("TypeVehicule.delete"));
                permissions.add(new Permission("Vehicule.edit"));
                permissions.add(new Permission("Vehicule.list"));
                permissions.add(new Permission("Vehicule.view"));
                permissions.add(new Permission("Vehicule.add"));
                permissions.add(new Permission("Vehicule.delete"));
                permissions.add(new Permission("Carburant.edit"));
                permissions.add(new Permission("Carburant.list"));
                permissions.add(new Permission("Carburant.view"));
                permissions.add(new Permission("Carburant.add"));
                permissions.add(new Permission("Carburant.delete"));
                permissions.add(new Permission("Garantie.edit"));
                permissions.add(new Permission("Garantie.list"));
                permissions.add(new Permission("Garantie.view"));
                permissions.add(new Permission("Garantie.add"));
                permissions.add(new Permission("Garantie.delete"));
                permissions.add(new Permission("ContratGarantie.edit"));
                permissions.add(new Permission("ContratGarantie.list"));
                permissions.add(new Permission("ContratGarantie.view"));
                permissions.add(new Permission("ContratGarantie.add"));
                permissions.add(new Permission("ContratGarantie.delete"));
                permissions.add(new Permission("ClientSininstre.edit"));
                permissions.add(new Permission("ClientSininstre.list"));
                permissions.add(new Permission("ClientSininstre.view"));
                permissions.add(new Permission("ClientSininstre.add"));
                permissions.add(new Permission("ClientSininstre.delete"));
                permissions.add(new Permission("Client.edit"));
                permissions.add(new Permission("Client.list"));
                permissions.add(new Permission("Client.view"));
                permissions.add(new Permission("Client.add"));
                permissions.add(new Permission("Client.delete"));
                permissions.add(new Permission("NatureContrat.edit"));
                permissions.add(new Permission("NatureContrat.list"));
                permissions.add(new Permission("NatureContrat.view"));
                permissions.add(new Permission("NatureContrat.add"));
                permissions.add(new Permission("NatureContrat.delete"));
                permissions.add(new Permission("Sinistre.edit"));
                permissions.add(new Permission("Sinistre.list"));
                permissions.add(new Permission("Sinistre.view"));
                permissions.add(new Permission("Sinistre.add"));
                permissions.add(new Permission("Sinistre.delete"));
                permissions.add(new Permission("QuittanceIndemniser.edit"));
                permissions.add(new Permission("QuittanceIndemniser.list"));
                permissions.add(new Permission("QuittanceIndemniser.view"));
                permissions.add(new Permission("QuittanceIndemniser.add"));
                permissions.add(new Permission("QuittanceIndemniser.delete"));
                permissions.add(new Permission("Admin.edit"));
                permissions.add(new Permission("Admin.list"));
                permissions.add(new Permission("Admin.view"));
                permissions.add(new Permission("Admin.add"));
                permissions.add(new Permission("Admin.delete"));
                permissions.add(new Permission("QuittancePrime.edit"));
                permissions.add(new Permission("QuittancePrime.list"));
                permissions.add(new Permission("QuittancePrime.view"));
                permissions.add(new Permission("QuittancePrime.add"));
                permissions.add(new Permission("QuittancePrime.delete"));
                permissions.add(new Permission("Agent.edit"));
                permissions.add(new Permission("Agent.list"));
                permissions.add(new Permission("Agent.view"));
                permissions.add(new Permission("Agent.add"));
                permissions.add(new Permission("Agent.delete"));
                permissions.add(new Permission("Chercheur.edit"));
                permissions.add(new Permission("Chercheur.list"));
                permissions.add(new Permission("Chercheur.view"));
                permissions.add(new Permission("Chercheur.add"));
                permissions.add(new Permission("Chercheur.delete"));
                permissions.add(new Permission("Contrat.edit"));
                permissions.add(new Permission("Contrat.list"));
                permissions.add(new Permission("Contrat.view"));
                permissions.add(new Permission("Contrat.add"));
                permissions.add(new Permission("Contrat.delete"));
                permissions.add(new Permission("Marque.edit"));
                permissions.add(new Permission("Marque.list"));
                permissions.add(new Permission("Marque.view"));
                permissions.add(new Permission("Marque.add"));
                permissions.add(new Permission("Marque.delete"));
            }
        private static void addPermissionForGestionnaire(List
        <Permission> permissions){
                permissions.add(new Permission("Devise.edit"));
                permissions.add(new Permission("Devise.list"));
                permissions.add(new Permission("Devise.view"));
                permissions.add(new Permission("Devise.add"));
                permissions.add(new Permission("Devise.delete"));
                permissions.add(new Permission("TypeClient.edit"));
                permissions.add(new Permission("TypeClient.list"));
                permissions.add(new Permission("TypeClient.view"));
                permissions.add(new Permission("TypeClient.add"));
                permissions.add(new Permission("TypeClient.delete"));
                permissions.add(new Permission("Gestionnaire.edit"));
                permissions.add(new Permission("Gestionnaire.list"));
                permissions.add(new Permission("Gestionnaire.view"));
                permissions.add(new Permission("Gestionnaire.add"));
                permissions.add(new Permission("Gestionnaire.delete"));
                permissions.add(new Permission("TypeSinistre.edit"));
                permissions.add(new Permission("TypeSinistre.list"));
                permissions.add(new Permission("TypeSinistre.view"));
                permissions.add(new Permission("TypeSinistre.add"));
                permissions.add(new Permission("TypeSinistre.delete"));
                permissions.add(new Permission("TypeVehicule.edit"));
                permissions.add(new Permission("TypeVehicule.list"));
                permissions.add(new Permission("TypeVehicule.view"));
                permissions.add(new Permission("TypeVehicule.add"));
                permissions.add(new Permission("TypeVehicule.delete"));
                permissions.add(new Permission("Vehicule.edit"));
                permissions.add(new Permission("Vehicule.list"));
                permissions.add(new Permission("Vehicule.view"));
                permissions.add(new Permission("Vehicule.add"));
                permissions.add(new Permission("Vehicule.delete"));
                permissions.add(new Permission("Carburant.edit"));
                permissions.add(new Permission("Carburant.list"));
                permissions.add(new Permission("Carburant.view"));
                permissions.add(new Permission("Carburant.add"));
                permissions.add(new Permission("Carburant.delete"));
                permissions.add(new Permission("Garantie.edit"));
                permissions.add(new Permission("Garantie.list"));
                permissions.add(new Permission("Garantie.view"));
                permissions.add(new Permission("Garantie.add"));
                permissions.add(new Permission("Garantie.delete"));
                permissions.add(new Permission("ContratGarantie.edit"));
                permissions.add(new Permission("ContratGarantie.list"));
                permissions.add(new Permission("ContratGarantie.view"));
                permissions.add(new Permission("ContratGarantie.add"));
                permissions.add(new Permission("ContratGarantie.delete"));
                permissions.add(new Permission("ClientSininstre.edit"));
                permissions.add(new Permission("ClientSininstre.list"));
                permissions.add(new Permission("ClientSininstre.view"));
                permissions.add(new Permission("ClientSininstre.add"));
                permissions.add(new Permission("ClientSininstre.delete"));
                permissions.add(new Permission("Client.edit"));
                permissions.add(new Permission("Client.list"));
                permissions.add(new Permission("Client.view"));
                permissions.add(new Permission("Client.add"));
                permissions.add(new Permission("Client.delete"));
                permissions.add(new Permission("NatureContrat.edit"));
                permissions.add(new Permission("NatureContrat.list"));
                permissions.add(new Permission("NatureContrat.view"));
                permissions.add(new Permission("NatureContrat.add"));
                permissions.add(new Permission("NatureContrat.delete"));
                permissions.add(new Permission("Sinistre.edit"));
                permissions.add(new Permission("Sinistre.list"));
                permissions.add(new Permission("Sinistre.view"));
                permissions.add(new Permission("Sinistre.add"));
                permissions.add(new Permission("Sinistre.delete"));
                permissions.add(new Permission("QuittanceIndemniser.edit"));
                permissions.add(new Permission("QuittanceIndemniser.list"));
                permissions.add(new Permission("QuittanceIndemniser.view"));
                permissions.add(new Permission("QuittanceIndemniser.add"));
                permissions.add(new Permission("QuittanceIndemniser.delete"));
                permissions.add(new Permission("Admin.edit"));
                permissions.add(new Permission("Admin.list"));
                permissions.add(new Permission("Admin.view"));
                permissions.add(new Permission("Admin.add"));
                permissions.add(new Permission("Admin.delete"));
                permissions.add(new Permission("QuittancePrime.edit"));
                permissions.add(new Permission("QuittancePrime.list"));
                permissions.add(new Permission("QuittancePrime.view"));
                permissions.add(new Permission("QuittancePrime.add"));
                permissions.add(new Permission("QuittancePrime.delete"));
                permissions.add(new Permission("Agent.edit"));
                permissions.add(new Permission("Agent.list"));
                permissions.add(new Permission("Agent.view"));
                permissions.add(new Permission("Agent.add"));
                permissions.add(new Permission("Agent.delete"));
                permissions.add(new Permission("Chercheur.edit"));
                permissions.add(new Permission("Chercheur.list"));
                permissions.add(new Permission("Chercheur.view"));
                permissions.add(new Permission("Chercheur.add"));
                permissions.add(new Permission("Chercheur.delete"));
                permissions.add(new Permission("Contrat.edit"));
                permissions.add(new Permission("Contrat.list"));
                permissions.add(new Permission("Contrat.view"));
                permissions.add(new Permission("Contrat.add"));
                permissions.add(new Permission("Contrat.delete"));
                permissions.add(new Permission("Marque.edit"));
                permissions.add(new Permission("Marque.list"));
                permissions.add(new Permission("Marque.view"));
                permissions.add(new Permission("Marque.add"));
                permissions.add(new Permission("Marque.delete"));
            }
        private static void addPermissionForAgent(List
        <Permission> permissions){
                permissions.add(new Permission("Devise.edit"));
                permissions.add(new Permission("Devise.list"));
                permissions.add(new Permission("Devise.view"));
                permissions.add(new Permission("Devise.add"));
                permissions.add(new Permission("Devise.delete"));
                permissions.add(new Permission("TypeClient.edit"));
                permissions.add(new Permission("TypeClient.list"));
                permissions.add(new Permission("TypeClient.view"));
                permissions.add(new Permission("TypeClient.add"));
                permissions.add(new Permission("TypeClient.delete"));
                permissions.add(new Permission("Gestionnaire.edit"));
                permissions.add(new Permission("Gestionnaire.list"));
                permissions.add(new Permission("Gestionnaire.view"));
                permissions.add(new Permission("Gestionnaire.add"));
                permissions.add(new Permission("Gestionnaire.delete"));
                permissions.add(new Permission("TypeSinistre.edit"));
                permissions.add(new Permission("TypeSinistre.list"));
                permissions.add(new Permission("TypeSinistre.view"));
                permissions.add(new Permission("TypeSinistre.add"));
                permissions.add(new Permission("TypeSinistre.delete"));
                permissions.add(new Permission("TypeVehicule.edit"));
                permissions.add(new Permission("TypeVehicule.list"));
                permissions.add(new Permission("TypeVehicule.view"));
                permissions.add(new Permission("TypeVehicule.add"));
                permissions.add(new Permission("TypeVehicule.delete"));
                permissions.add(new Permission("Vehicule.edit"));
                permissions.add(new Permission("Vehicule.list"));
                permissions.add(new Permission("Vehicule.view"));
                permissions.add(new Permission("Vehicule.add"));
                permissions.add(new Permission("Vehicule.delete"));
                permissions.add(new Permission("Carburant.edit"));
                permissions.add(new Permission("Carburant.list"));
                permissions.add(new Permission("Carburant.view"));
                permissions.add(new Permission("Carburant.add"));
                permissions.add(new Permission("Carburant.delete"));
                permissions.add(new Permission("Garantie.edit"));
                permissions.add(new Permission("Garantie.list"));
                permissions.add(new Permission("Garantie.view"));
                permissions.add(new Permission("Garantie.add"));
                permissions.add(new Permission("Garantie.delete"));
                permissions.add(new Permission("ContratGarantie.edit"));
                permissions.add(new Permission("ContratGarantie.list"));
                permissions.add(new Permission("ContratGarantie.view"));
                permissions.add(new Permission("ContratGarantie.add"));
                permissions.add(new Permission("ContratGarantie.delete"));
                permissions.add(new Permission("ClientSininstre.edit"));
                permissions.add(new Permission("ClientSininstre.list"));
                permissions.add(new Permission("ClientSininstre.view"));
                permissions.add(new Permission("ClientSininstre.add"));
                permissions.add(new Permission("ClientSininstre.delete"));
                permissions.add(new Permission("Client.edit"));
                permissions.add(new Permission("Client.list"));
                permissions.add(new Permission("Client.view"));
                permissions.add(new Permission("Client.add"));
                permissions.add(new Permission("Client.delete"));
                permissions.add(new Permission("NatureContrat.edit"));
                permissions.add(new Permission("NatureContrat.list"));
                permissions.add(new Permission("NatureContrat.view"));
                permissions.add(new Permission("NatureContrat.add"));
                permissions.add(new Permission("NatureContrat.delete"));
                permissions.add(new Permission("Sinistre.edit"));
                permissions.add(new Permission("Sinistre.list"));
                permissions.add(new Permission("Sinistre.view"));
                permissions.add(new Permission("Sinistre.add"));
                permissions.add(new Permission("Sinistre.delete"));
                permissions.add(new Permission("QuittanceIndemniser.edit"));
                permissions.add(new Permission("QuittanceIndemniser.list"));
                permissions.add(new Permission("QuittanceIndemniser.view"));
                permissions.add(new Permission("QuittanceIndemniser.add"));
                permissions.add(new Permission("QuittanceIndemniser.delete"));
                permissions.add(new Permission("Admin.edit"));
                permissions.add(new Permission("Admin.list"));
                permissions.add(new Permission("Admin.view"));
                permissions.add(new Permission("Admin.add"));
                permissions.add(new Permission("Admin.delete"));
                permissions.add(new Permission("QuittancePrime.edit"));
                permissions.add(new Permission("QuittancePrime.list"));
                permissions.add(new Permission("QuittancePrime.view"));
                permissions.add(new Permission("QuittancePrime.add"));
                permissions.add(new Permission("QuittancePrime.delete"));
                permissions.add(new Permission("Agent.edit"));
                permissions.add(new Permission("Agent.list"));
                permissions.add(new Permission("Agent.view"));
                permissions.add(new Permission("Agent.add"));
                permissions.add(new Permission("Agent.delete"));
                permissions.add(new Permission("Chercheur.edit"));
                permissions.add(new Permission("Chercheur.list"));
                permissions.add(new Permission("Chercheur.view"));
                permissions.add(new Permission("Chercheur.add"));
                permissions.add(new Permission("Chercheur.delete"));
                permissions.add(new Permission("Contrat.edit"));
                permissions.add(new Permission("Contrat.list"));
                permissions.add(new Permission("Contrat.view"));
                permissions.add(new Permission("Contrat.add"));
                permissions.add(new Permission("Contrat.delete"));
                permissions.add(new Permission("Marque.edit"));
                permissions.add(new Permission("Marque.list"));
                permissions.add(new Permission("Marque.view"));
                permissions.add(new Permission("Marque.add"));
                permissions.add(new Permission("Marque.delete"));
            }


            }


