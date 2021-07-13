Design Patterns folosite: Singleton, Factory, Builder, Observer, Strategy.

Aplicatie care tine evidenta notelor unor studenti la fiecare materie. Aceasta
trimite notificari parintilor studentului atunci cand acesta obtine o nota noua.

Singleton  - clasa Catalog - o singura instanta.

Builder    - clasa Course.

Observer   - aplicația le permite parinților unui student sa se aboneze la
	     Catalog pentru a putea primi notificari în momentul în care studentul
	     este notat de catre un profesor sau de catre un asistent.

Factory    - crearea de Studenti, Profesori, Asistenti si Parinti.

Strategy   - la sfarsitul semestrului profesorul selecteaza cel mai bun student conform
	     unei politici: BestPartialScore, BestExamScore, BestTotalScore.
