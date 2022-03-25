package ma.enset.service;

import org.springframework.stereotype.Service;

@Service
public class MetierImpl implements IMetier {
    @Override
    public void process() {
        System.out.println("Business Process ......");
    }

    @Override
    public double compute() {
        double data = 1 ;
        System.out.println("Business Computing and returning ......");
        return data;
    }
}
