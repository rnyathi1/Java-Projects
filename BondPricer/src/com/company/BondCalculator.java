package com.company;

public class BondCalculator {
    double faceV;
    double couponR;
    double frq;
    double yield;
    double my;

    public BondCalculator(double faceV, double couponR, double frq, double yield, double my){
        this.faceV = faceV;
        this.couponR = couponR;
        this.frq = frq;
        this.yield = yield;
        this.my = my;
    }

    public double bondPriceCalculator(double faceV, double couponR, double frq, double yield, double my){
        double bondPrice = 0;
        double C = couponR * (faceV / frq) ;
        double r = yield / frq ;
        double N = my * frq;
        double F = faceV;

        for(int i = 1; i <= N; i++){
            bondPrice = bondPrice + ((C / Math.pow((1 + r),i)));
        }
        bondPrice += (F / Math.pow((1 + r),N));
        return bondPrice;
    }
}
