# Implementimi i book cipher i cili shfrytezon nje tekst dokument si liber


## Universiteti

 Universiteti i Prishtinës - Fakulteti i Inxhinierisë Elektrike dhe Kompjuterike 
 Departmenti - Inxhinieri kompjuterike dhe softuerike
*Ky është projekti i dytë nga kursi i Sigurisë së të Dhënave i cili u dha dhe u mbikqyr nga asistenti Mërgim Hoti.

## Gjuha programuese

Ky projekt është zhvilluar me gjuhën programuese JAVA

## Si të përdoret

1. Sigurohuni që të keni instaluar JDK në pajisjen tuaj.
2. Klononi repositorinë ose shkarkoni dosjet e projektit.
3. Hapni projektin në mjedisin tuaj të preferuar Java IDE.
4. Ekzekutoni skriptën BookCipher.java.
5. Ndiqni udhëzimet për të futur tekstin ose kodin e enkoduar dhe shikoni rezultatin.


## Kontribuesit

 - Adrian Mehaj

 - Afrim Ymeri

 - Ag Hamiti

 - Adna Aslani


## Përmbledhje

Një BookCipher është një metodë kriptografike në të cilën çdo fjalë ose shkronjë në tekstin e hapur të një mesazhi zëvendësohet me një kod që e lokalizon atë në një tekst tjetër, i quajtur çelës. Një version i thjeshtë i këtij ciphers do të përdorte një libër të caktuar si çelës dhe do të zëvendësonte çdo fjalë të tekstit të hapur me një numër që tregon pozicionin ku ajo fjalë ndodhet në atë libër.

## Shembull

Për shembull, nëse çelësi i zgjedhur është romani "Lufta e Botëve" nga H. G. Wells, dhe teksti i hapur "të gjithë planet dështuan, të kthehesh nesër" mund të kodohet si "335 219 881, 5600 853 9315", pasi fjala e 335-të në roman është "të gjithë", ndërsa fjala e 219-ta është "planet", dhe kështu me radhë. Kjo metodë kërkon që dërguesi dhe pranuesi të përdorin të njëjtin edicion të librit çelës.


## Variantet

Për të adresuar kufizimin e fjalëve që nuk shfaqen në tekstin e çelësit, një variant i BookCipher punon me shkronjat individuale në vend të fjalëve. Secila shkronjë në tekst hapur zëvendësohet me një numër që tregon pozicionin e saj në tekstin e çelësit. Për shembull, duke përdorur librin "War of the Worlds" si çelës, mesazhi "pa municion" mund të kodohet si "12 10 / 50 31 59 34" përfaqësuar pozicionet e shkronjave në tekst çelës.

## Përdorimi

BookCipher, sidomos në variantin e tyre me shkronja, janë një formë e cifrës së zëvendësimit. Çelësi është shpesh një libër që liston fjalë ose shkronja me numrat e tyre korrespondentë. Të dy palët duhet të kenë një kopje identike të tekstit çelës. Ndërsa BookCiphers ofrojnë përfitime të sigurisë, ato kërkojnë zgjedhje të kujdesshme të teksteve çelës që nuk do të nxisin dyshime dhe duhet të mbahen me kujdes.

## Avantazhet dhe disavantazhet

Avantazhi kryesor i BookCipher qëndron te çelësi, që mund të jetë çdo libër ose publikim në pajtim me dërguesin dhe pranuesin e mesazheve të koduara. Megjithatë, dobësia është se të dyja palët duhet të kenë qasje në të njëjtin tekst çelës. Në kontekstin e spiunazhit, BookCiphers ofrojnë avantazhe në krahasim me librat e zakonshëm të kodit, por kërkojnë kujdes në zgjedhjen e librave.

## Implementimi

Implementimi i BookCipher përfshin mapimin e fjalëve ose shkronjave të hapura në pozicionet e tyre në tekstin çelës dhe anasjelltas. Ky proces kërkon kujdes të veçantë për detajet dhe përputhjen e teksteve çelës midis dërguesit dhe pranuesit. Ndërsa është një punë e lodhshme, BookCipher ofrojnë një metodë të veçantë dhe potencialisht efektive të komunikimit të sigurt.