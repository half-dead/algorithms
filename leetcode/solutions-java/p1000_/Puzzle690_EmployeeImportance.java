package p1000_;

import struct.Employee;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/employee-importance/
 *
 * @author half-dead
 */
public class Puzzle690_EmployeeImportance {

    class Solution {
        public int getImportance(List<Employee> employees, int id) {
            Map<Integer, Employee> map = new HashMap<>();
            for (Employee emp : employees) {
                map.put(emp.id, emp);
            }

            int result = 0;
            LinkedList<Integer> q = new LinkedList<>();
            q.push(id);
            while (q.size() > 0) {
                Employee e = map.get(q.pop());
                result += e.importance;
                for (int so : e.subordinates) {
                    q.push(so);
                }
            }
            return result;
        }
    }
}
