package pro.sky.hw.model;


import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    private final Map<String, Employee> eBook;

    public DepartmentServiceImpl() {

        eBook = new HashMap<>();

        eBook.put("ИванИвановичИванцов", new Employee("Иван", "Иванович", "Иванцов", 0, 50_000));
        eBook.put("ПетрИннокентьевичПетров", new Employee("Петр", "Иннокентьевич", "Петров", 0, 150_000));
        eBook.put("СеменСеменовичГорбунков", new Employee("Семен", "Семенович", "Горбунков", 1, 101_000));
        eBook.put("ИннокентийБорисовичЧулков", new Employee("Иннокентий", "Борисович", "Чулков", 1, 120_000));
        eBook.put("СергейАнуфриевичЯбеда", new Employee("Сергей", "Ануфриевич", "Ябеда", 2, 40_000));
        eBook.put("ИосифВахтанговичГришин", new Employee("Иосиф", "Вахтангович", "Гришин", 2, 91_000));
        eBook.put("ИванИвановичИванов", new Employee("Иван", "Иванович", "Иванов", 3, 50_000));
        eBook.put("АлибекДжунгаровичХомяков", new Employee("Алибек", "Джунгарович", "Хомяков", 3, 42_000));
        eBook.put("РустамИбрагимовичСулейбеков", new Employee("Рустам", "Ибрагимович", "Сулейбеков", 4, 22_000));
        eBook.put("ЗухраПетровнаДжугашвилли", new Employee("Зухра", "Петровна", "Джугашвилли", 4, 173_000));
        Employee e = new Employee("Казбек", "Дмитриевич", "Светлый", 5, 17_500);
        String key = e.getFirstName() + e.getMiddleName() + e.getLastName();
        eBook.put(key, e);
        eBook.put("СулейманМыколовичБеспамятный", new Employee("Сулейман", "Мыколович", "Беспамятный", 5, 23_700));
        eBook.put("МихайлоДмитриевичГлавко", new Employee("Михайло", "Дмитриевич", "Главко", 6, 110_300));
        eBook.put("ЕленаАрменовнаАкопян", new Employee("Елена", "Арменовна", "Акопян", 6, 199_999.99));
        eBook.put("ГюльчатайЗурабовнаСухова", new Employee("Гюльчатай", "Зурабовна", "Сухова", 7, 69_000));
        eBook.put("НатальяАльбертовнаРабинович", new Employee("Наталья", "Альбертовна", "Рабинович", 7, 29_794));

    }

    @Override
    public Employee findEmployeeWithMaxSalary(int department) {
        return eBook.keySet().stream()
                .filter(s -> eBook.get(s).getDepartment() == department)
                .map(eBook::get)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new RuntimeException("Wrong department number in the " +
                        "DepartmentService.findEmployeeWithMaxSalary() method argument!"));
    }

    @Override
    public Employee findEmployeeWithMinSalary(int department) {
        return eBook.keySet().stream()
                .filter(s -> eBook.get(s).getDepartment() == department)
                .map(eBook::get)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new RuntimeException("Wrong department number in the " +
                        "DepartmentService.findEmployeeWithMaxSalary() method argument!"));
    }

    @Override
    public Map<Integer, Set<Employee>> departmentEmployeeList(int department) {
        return eBook.keySet().stream()
                .filter(s -> eBook.get(s).getDepartment() == department)
                .map(eBook::get)
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toSet()));
    }

    @Override
    public Map<Integer, Set<Employee>> allDepartmentsEmployeeList() {
        return eBook.keySet().stream()
                .map(eBook::get)
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toSet()));
    }

}
