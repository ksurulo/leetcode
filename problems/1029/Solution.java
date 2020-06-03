import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution
{
   public int twoCitySchedCost(int[][] costs)
   {
      List<ValueDifference> valueDifferences = new ArrayList();
      for (int i = 0; i < costs.length; i++)
      {
         valueDifferences.add(new ValueDifference(i, Math.abs(costs[i][0] - costs[i][1])));
      }
      Collections.sort(valueDifferences, new DiffrenceComparator());

      int cityOnePeople = 0;
      int cityTwoPeople = 0;
      int maxCityPeople = costs.length / 2;
      int result = 0;
      for (ValueDifference difference : valueDifferences)
      {
         if (cityOnePeople == maxCityPeople)
         {
            result += costs[difference.index][1];
            cityTwoPeople++;
         }
         else if (cityTwoPeople == maxCityPeople)
         {
            result += costs[difference.index][0];
            cityOnePeople++;
         }
         else
         {
            int chosenCity = costs[difference.index][0] > costs[difference.index][1] ? 1 : 0;
            result += costs[difference.index][chosenCity];
            if (chosenCity == 0)
            {
               cityOnePeople++;
            }
            else
            {
               cityTwoPeople++;
            }
         }

      }
      return result;
   }

   class ValueDifference
   {
      int index;
      int value;

      public ValueDifference(int index, int value)
      {
         this.index = index;
         this.value = value;
      }
   }

   class DiffrenceComparator implements Comparator<ValueDifference>
   {
      public int compare(ValueDifference a, ValueDifference b)
      {
         return b.value - a.value;
      }
   }

   public static void main(String[] args)
   {
      int[][] costs = { { 259, 770 }, { 448, 54 }, { 926, 667 }, { 184, 139 }, { 840, 118 }, { 577, 469 } };
      Solution solution = new Solution();
      solution.twoCitySchedCost(costs);
   }
}
