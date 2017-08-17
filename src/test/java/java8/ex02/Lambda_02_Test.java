package java8.ex02;

import java8.data.Account;
import java8.data.Data;
import java8.data.Person;
import java8.ex01.Lambda_01_Test.PersonPredicate;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * Exercice 02 - Map
 */
public class Lambda_02_Test<T> {

    // tag::PersonToAccountMapper[]
    interface PersonToAccountMapper<T> {
        T map(Person p);
    }
    // end::PersonToAccountMapper[]
    
    // tag::map[]
    private List<T> map(List<Person> personList, PersonToAccountMapper mapper) {
        // TODO implémenter la méthode pour transformer une liste de personnes en liste de comptes
    	List<T> a = new ArrayList<T>();
    	for (Person p : personList) {   
    		a.add((T) mapper.map(p));
        }
    	return a;
    }
    // end::map[]
    
    // tag::test_map_person_to_account[]
    @Test
    public void test_map_person_to_account() throws Exception {

        List<Person> personList = Data.buildPersonList(100);

        // TODO transformer la liste de personnes en liste de comptes
        // TODO tous les objets comptes ont un solde à 100 par défaut
 
        PersonToAccountMapper personToAccountMapper = p -> { Account ac = new Account();
        													ac.setBalance(100);ac.setOwner(p); return ac;
        													};
        List<Account> result = (List<Account>) map(personList, personToAccountMapper);

        assert result.size() == personList.size();
        for (Account account : result) {
            assert account.getBalance().equals(100);
            assert account.getOwner() != null;
        }
    }
    // end::test_map_person_to_account[]

    // tag::test_map_person_to_firstname[]
    @Test
    public void test_map_person_to_firstname() throws Exception {

        List<Person> personList = Data.buildPersonList(100);

        PersonToAccountMapper personToAccountMapper = p -> { return p.getFirstname();};

        List<String> result = (List<String>) map(personList, personToAccountMapper);



        assert result.size() == personList.size();
        for (String firstname : result) {
            assert firstname.startsWith("first");
        }
    }
    // end::test_map_person_to_firstname[]
}
