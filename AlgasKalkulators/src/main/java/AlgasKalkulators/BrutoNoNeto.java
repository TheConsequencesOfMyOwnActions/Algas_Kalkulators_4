package AlgasKalkulators;

public class BrutoNoNeto {
    static double Rezultats;

    public static double brutoNoNeto(double Eiro, int Apgad, double Min, int GadaVert, int cituAtvieglSumma, int Inval,
            double VSAOI_LIKME) {
        double Rezultats = 0;
        if (Eiro > 1667 * (1 - VSAOI_LIKME - 0.23)) {
            Rezultats = lielais(Eiro, Apgad, Min, GadaVert, cituAtvieglSumma, Inval, VSAOI_LIKME);
        } else {
            Rezultats = mazais(Eiro, Apgad, Min, GadaVert, cituAtvieglSumma, Inval, VSAOI_LIKME);
        }
        return Rezultats;
    }

    public static double lielais(double Eiro, int Apgad, double Min, int GadaVert, int cituAtvieglSumma, int Inval,
            double VSAOI_LIKME) {
        double bruto = 1667;
        double pieskaitamais = 0.01;
        while (true) {
            double lielaisBruto = 1667;
            double mazaisBruto = bruto - lielaisBruto;
            double VSAOI = bruto * VSAOI_LIKME;
            double aplMin = lielaisBruto - VSAOI - (Apgad * GadaVert) - Min - cituAtvieglSumma - Inval;
            double lielaisIIN = 0.2 * aplMin;
            if ((Apgad * GadaVert) >= Eiro) {
                lielaisIIN = 0;
            }
            double mazaisIIN = 0.23 * mazaisBruto;
            double IIN = mazaisIIN + lielaisIIN;
            if (IIN < 0) {
                IIN = 0;
            }
            double aprekinataisNeto = bruto - VSAOI - IIN;
            if (Math.abs(aprekinataisNeto - Eiro) < pieskaitamais) {
                break;
            }
            bruto += pieskaitamais;
        }
        return bruto;
    }

    public static double mazais(double Eiro, int Apgad, double Min, int GadaVert, int cituAtvieglSumma, int Inval,
            double VSAOI_LIKME) {
        double bruto = Eiro;
        double pieskaitamais = 0.01;
        while (true) {
            double VSAOI = bruto * VSAOI_LIKME;
            double iin = 0.2 * (bruto - VSAOI - (Apgad * GadaVert) - Min - cituAtvieglSumma - Inval);
            if (iin < 0) {
                iin = 0;
            }
            double aprekinataisNeto = bruto - VSAOI - iin;
            if (Math.abs(aprekinataisNeto - Eiro) < pieskaitamais) {
                break;
            }
            bruto += pieskaitamais;
        }
        return bruto;
    }
}