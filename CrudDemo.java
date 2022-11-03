import java.util.*;

class Employee {
	private int empno;
	private String ename;
	private int salary;

	Employee(int empno, String ename, int salary) {
		this.empno = empno;
		this.ename = ename;
		this.salary = salary;

	}

	public int getEmpno() {
		return empno;
	}
	public String getEname() {
		return ename;
	}
	public int getSalary() {
		return salary;
	}

	public String toString() {
		return empno + " " + ename + " " + salary;
	}
}

class CrudDemo{
	public static void main (String[] args) {
		List<Employee> c = new ArrayList<Employee>();
		int pick;
		Scanner scan = new Scanner(System.in);
		Scanner stringScanner = new Scanner(System.in);
		do {
			System.out.println("1. INSERT");
			System.out.println("2. UPDATE");
			System.out.println("3. DELETE");
			System.out.println("4. SEARCH");
			System.out.println("5. DISPLAY");
			System.out.println("Enter your pick:");
			pick = scan.nextInt();

			switch (pick) {
				case 1:

					System.out.print("Enter the employee number: ");
					int eno = scan.nextInt();
					System.out.print("Enter the employee name: ");
					String ename = stringScanner.nextLine();
					System.out.print("Enter the employee salary: ");
					int salary = scan.nextInt();

					c.add(new Employee(eno, ename, salary)); //adds a new employee object to our collection 
					System.out.println("-------------------------------");
					System.out.println("Successfully added " + ename + " to the collection!");
					System.out.println("-------------------------------");

					break;

				case 2:
					boolean found = false; //creating a flag
					Iterator<Employee> i =  c.iterator();
					System.out.println("Enter the employee number you would like to UPDATE: ");
					int empno = scan.nextInt();
					System.out.println("-------------------------------");
					ListIterator<Employee> li = c.listIterator();
					while (li.hasNext()) {
						Employee e = li.next();
						if (e.getEmpno() == empno) {
							System.out.println("Enter a new name: ");
							ename = stringScanner.nextLine();

							System.out.println("Enter a new salary");
							salary = scan.nextInt();

							li.set(new Employee(empno, ename, salary));
							found = true;
						}
					}

					if (!found) {
						System.out.println("Results: Record is not found.");
					} else {
						System.out.println("Results: Record is successfully updated.");
					}

					break;
				case 3:
					found = false; //creating a flag
					System.out.println("Enter the employee number you would like to DELETE: ");
					empno = scan.nextInt();
					System.out.println("-------------------------------");
					i = c.iterator();
					while (i.hasNext()) {
						Employee e = i.next();
						if (e.getEmpno() == empno) {
							i.remove();
							found = true;
						}
					}

					if (!found) {
						System.out.println("Results: Employee number not found in our collection.");
					} else {
						System.out.println("Results: Record is successfully deleted forever.");
					}

					break;
				case 4:
					found = false; //creating a flag
					System.out.println("Enter the employee number you would like to search: ");
					empno = scan.nextInt();
					System.out.println("-------------------------------");
					i = c.iterator();
					while (i.hasNext()) {
						Employee e = i.next();
						if (e.getEmpno() == empno) {
							System.out.println("Results: " + e);
							found = true;
						}
					}

					if (!found) {
						System.out.println("Results: Employee number not found in our collection.");
					}


					break;
				case 5:
					System.out.println("-------------------------------");
					i = c.iterator();
					while (i.hasNext()) {
						Employee e = i.next();
						System.out.println(e);

					}
					System.out.println("-------------------------------");

					break;
			}


		} while (pick != 0);
	}
}