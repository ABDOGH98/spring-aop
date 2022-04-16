package ma.enset.service;

import ma.enset.aspect.Log;
import ma.enset.aspect.SecuredByAspect;
import org.springframework.stereotype.Service;

@Service
public class MetierImpl implements IMetier {
    @Override
    @Log
    @SecuredByAspect(roles={"USER"})
    public void process() {
        System.out.println("Business Process ......");
    }

    @Override
    @Log
    @SecuredByAspect(roles={"ADMIN"})
    public double compute() {
        double data = 1 ;
        System.out.println("Business Computing and returning ......");
        return data;
    }
}
