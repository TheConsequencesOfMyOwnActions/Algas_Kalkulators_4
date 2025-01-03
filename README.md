# Algas_Kalkulators_4

 -Šī ir programma, kas izmantojama algas aprēķināšanai dažādos gados (no 2016. līdz 2025. gadam).
 -Var rēķināt neto no bruto algas un otrādi.

 ##Darbvirsmas programma
Darbvirsmas programmu sapakotu kopā ar atbilstošo java versiju (lai programma darbotos uz jebkura datora) var lejuplādēt šeit:< br / >
https://drive.google.com/file/d/1qri05jse1g0-cSDxZYNOo75cVE-kmEts/view?usp=drive_link< br / >
Vai var to izveidot šādi:< br / >
 -exportē jar failu< br / >
 -ar Launch4j aplikācijas palīdzību izveido .exe aplikāciju< br / >
  (sadaļā JRE Paths norādot jdk)< br / >
 -ar Inno Setup aplikācijas palīdzību iepako klāt java 23.versiju< br / >
   (to avr iegūt šeit: https://www.oracle.com/java/technologies/downloads/)< br / >
 -Inno Setup veido jaunu skriptu un raksta šo (neaizmirstiet izlabot ceļus atbilstoši Jūsu datoram):< br / >
  [Setup]
AppName=Algas Kalkulators
AppVersion=1.0
DefaultDirName={pf}\Algas Kalkulators
DefaultGroupName=Algas Kalkulators
OutputDir=C:\Users\piemērs\Desktop\Output
OutputBaseFilename=Algas_Kalkulators_Setup
Compression=lzma
SolidCompression=yes

[Files]
; Copy the executable
Source: "C:\Users\piemērs\Desktop\Algas Kalkulators\Algas_Kalkulators.exe"; DestDir: "{app}"; Flags: ignoreversion
; Copy the bundled JDK
Source: "C:\Program Files\Java\jdk-23\*"; DestDir: "{app}\jdk"; Flags: recursesubdirs createallsubdirs

[Run]
; Run the executable after installation
Filename: "{app}\Algas_Kalkulators.exe"; Description: "Launch Algas Kalkulators"; Flags: nowait postinstall
-Izveidosies Algas_Kalkulators_Setup.exe, pēc kura instalācijas būs pieejama Algas Kalkulatora programma.

 
