public class multithreadingMain {
    public static void main(String[] args) {
        /*
        fundamental basis behind multithreading
        1. by default programming languages are sequential
        2.

           public static void main(String[] args)
           {
               initialzeArrays();
               downloadStocks();
               intiializeTimeSeriesModels();
           }

           only until initializeArrays() is finished, then only
           it will start downloading stocks

           time consuming operations may freeze the application!

           we may need to create a distinct thread for downloadStocks() so that
           during this procedure the user can do whatever she wants
           so that the application doesnt freeze

           every process has its own distinct
           1. register
           2. program counter
           3. stack memory
           4. heap memory

           what is the time slicing algorithm ?

           a process may have several threads

           each thread in a process shares the memory and resources
           (synchronization)



         */
    }
}
