package AlgasKalkulators;

public class NetoNoBruto {
    static double Rezultats;

    public static double netoNoBruto(double Eiro, int Apgad, double Min, int GadaVert, int cituAtvieglSumma, int Inval,
            double VSAOI_LIKME) {
        if (Eiro < 1667) {
            Rezultats = netoMazais(Eiro, Apgad, Min, GadaVert, cituAtvieglSumma, Inval, VSAOI_LIKME);
        } else {
            Rezultats = netoLielais(Eiro, Apgad, Min, GadaVert, cituAtvieglSumma, Inval, VSAOI_LIKME);
        }
        return Rezultats;
    }

    public static double netoMazais(double Eiro, int Apgad, double Min, int GadaVert, int cituAtvieglSumma, int Inval,
            double VSAOI_LIKME) {
        double VSAOI = Eiro * VSAOI_LIKME;
        double iin = 0.2 * (Eiro - VSAOI - (Apgad * GadaVert) - Min - cituAtvieglSumma - Inval);
        if (iin < 0) {
            iin = 0;
        }
        double neto = (Eiro - VSAOI - iin);
        return neto;
    }

    public static double netoLielais(double Eiro, int Apgad, double Min,
            int GadaVert, int cituAtvieglSumma, int Inval,
            double VSAOI_LIKME) {
        double lielaisBruto = 1667;
        double mazaisBruto = Eiro - lielaisBruto;
        double VSAOI = Eiro * VSAOI_LIKME;
        double aplMin = (lielaisBruto - VSAOI - (Apgad * GadaVert) - Min
                - cituAtvieglSumma - Inval);
        double lielaisIIN = 0.2 * aplMin;
        if ((Apgad * GadaVert) >= Eiro) {
            lielaisIIN = 0;
        }
        double mazaisIIN = 0.23 * mazaisBruto;
        double IIN = mazaisIIN + lielaisIIN;
        if (IIN < 0) {
            IIN = 0;
        }
        double neto = (Eiro - VSAOI - IIN);
        return neto;
    }
}