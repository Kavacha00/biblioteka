# Projekt – Wzorce projektowe i zasady SOLID

## Tydzień 2 – Wzorce kreacyjne

### Factory Method

**Zofia Borys**

Plik: `StoreCreator`

Opis: Klasa bazowa (abstrakcyjna), która definiuje wspólny interfejs dla wszystkich kreatorów w systemie. Wykorzystuje metodę wytwórczą `createStore`, której konkretne implementacje w klasach `PhysicalStoreCreator` oraz `OnlineStoreCreator` decydują o tym, czy powstanie obiekt sklepu stacjonarnego, czy internetowego.

**Mateusz Kołtuniuk**

Plik: `UserCreator`

Opis: Klasa bazowa (abstrakcyjna), która definiuje wspólny interfejs dla wszystkich kreatorów w systemie. Wykorzystuje metodę wytwórczą `createUser`, której konkretne implementacje w klasach `CustomerCreator` oraz `EmployeeCreator` decydują o tym, jaki obiekt użytkownika powstanie.

**Adam Krawczyk**

Plik: `ItemCreator`

Opis: Klasa abstrakcyjna tworząca obiekty.

---

### Singleton

**Zofia Borys**

Plik: `PhysicalStoreCreator`

Opis: Klasa zapewnia istnienie tylko jednej instancji kreatora w pamięci aplikacji.

**Mateusz Kołtuniuk**

Plik: `EmployeeCreator`

Opis: Dzięki wykorzystaniu wzorca Thread Safe Singleton, w systemie może istnieć tylko jedna instancja tej klasy.

**Adam Krawczyk**

Plik: `BookCreator`

Opis: Zapewnia istnienie tylko jednej instancji klasy

---

### Builder

**Zofia Borys**

Plik: `PhysicalStoreBuilder`

Opis: Umożliwia krokowe konfigurowanie i tworzenie obiektów klasy `PhysicalStore`.

**Mateusz Kołtuniuk**

Plik: `EmployeeBuilder`

Opis: Dzięki wykorzystaniu wzorca Builder możemy tworzyć obiekt klasy `Employee` krok po kroku.

**Adam Krawczyk**

Plik: `BookBuilder`

Opis: Klasa tworząca obiekty

---

### Prototype

**Zofia Borys**

Plik: `Store`

Opis: Klasa implementuje interfejs `Cloneable` oraz nadpisuje metodę `clone`, umożliwiając tworzenie kopii istniejących obiektów sklepów bez konieczności przechodzenia przez proces ich ręcznej inicjalizacji.

**Mateusz Kołtuniuk**

Plik: `User`

Opis: Klasa implementuje interfejs `Cloneable`. Metoda `clone` pozwala stworzyć kopię głęboką obiektu.

**Adam Krawczyk**

Plik: `Item`

Opis: Klasa tworzy kopie obiektów implementując interfejs Cloneable

---

## Tydzień 3 – Wzorce strukturalne

### Adapter

**Zofia Borys**

Plik: `CsvReportAdapter`

Opis: Dostosowuje niekompatybilny interfejs klasy `CsvReportGenerator` do standardu `ReportService`, umożliwiając systemowi generowanie raportów wypożyczeń w formacie CSV bez zmiany istniejącej logiki biznesowej.

**Mateusz Kołtuniuk**

Plik: `OidcUserAdapter`

Opis: Wykorzystanie wzorca Adapter umożliwia pracę z obiektami `OidcUser` w ten sam sposób jak z wewnętrznym `User`.

**Adam Krawczyk**

Plik: `BookTranslateAdapter`, `ItemTranslatorObjectAdapterImpl`

Opis: Możliwość zmiany języka opisu.

---

### Composite

**Zofia Borys**

Plik: `StoreGroup`

Opis: Pozwala traktować pojedyncze obiekty sklepów oraz ich grupy w jednolity sposób poprzez agregację obiektów typu `Store` i delegowanie do nich operacji `processOrder()`.

**Mateusz Kołtuniuk**

Plik: `UserGroup`

Opis: Dzięki wzorcowi Composite możemy pracować z listą obiektów w taki sam sposób jak z jednym obiektem. Możemy na przykład wylogować całą kolekcję użytkowników wywołując metodę `logOut()`.

**Adam Krawczyk**

Plik: `AuthorCollection`

Opis: Możliwość zgrupowania wszystkich dzieł autora.

---

### Bridge

**Zofia Borys**

Plik: `BridgeStore`

Opis: Klasa oddziela logikę sklepu od konkretnego sposobu dostawy poprzez kompozycję z interfejsem `DeliveryMethod`. Dzięki temu można niezależnie rozwijać strukturę sklepów oraz metody dostarczania (takie jak `CourierDelivery` czy `ParcelLockerDelivery`) bez konieczności modyfikowania głównej klasy sklepu.

**Mateusz Kołtuniuk**

Plik: `EmployeeBuilderBridge`

Opis: Dzięki zastosowaniu wzorca Bridge oddzielamy abstrakcję (interfejs `EmployeeBuilder`) od implementacji (`DefaultEmployeeBuilder`). Tworząc obiekt Bridge, możemy wstrzyknąć taką implementację Buildera, jaką potrzebujemy.

**Adam Krawczyk**

Plik: `ItemFormat`

Opis: Podział itemu na format fizyczny i cyfrowy.

---

### Decorator

**Zofia Borys**

Plik: `StoreDecorator`

Opis: Klasa bazowa dla dekoratorów, która umożliwia dynamiczne rozszerzanie funkcjonalności obiektów `Store` poprzez opakowywanie ich w dodatkowe zachowania, takie jak szybka dostawa (`FastDeliveryDecorator`) czy naliczanie promocji (`PromotionDecorator`), bez modyfikacji ich pierwotnej struktury.

**Mateusz Kołtuniuk**
Pliki: `UserDecorator`, `FirstTimeLoginDecorator`

Opis: Wykorzystanie wzorca Decorator pozwala dynamicznie rozszerzyć funkcjonalność klasy poprzez opakowanie jej w inną klasę. `FirstTimeLoginDecorator` dodaje funkcjonalność do metody `logIn()` usera.

**Adam Krawczyk**

Plik: `ItemDecorator`, `BestsellerDecorator`

Opis: Możliwość dynamicznego dodania do itemu atrybutu „bestseller".

---

## Tydzień 4 – Wzorce strukturalne (cd.)

### Facade

**Zofia Borys**

Plik: `StoreFacade`

Opis: Udostępnia uproszczony interfejs do zarządzania procesami bibliotecznymi, takimi jak wypożyczanie i zwrot książek oraz generowanie raportów, ukrywając przy tym złożoność współpracy pomiędzy różnymi usługami i obiektami.

**Mateusz Kołtuniuk**

Plik: `UserRegistrationFacade`

Opis: Zastosowanie wzorca Facade upraszcza skomplikowany proces rejestracji użytkownika do wywołania jednej metody.

**Adam Krawczyk**

Plik: `ItemFacade`

Opis: Dotychczasowe funkcjonalności owite w jedną klasę, aby tworzenie książek było prostsze.

---

### Proxy

**Zofia Borys**

Plik: `ReportServiceProxy`

Opis: Działa jako pośrednik kontrolujący dostęp do usługi `ReportService`, weryfikując uprawnienia użytkownika przed umożliwieniem wygenerowania raportu.

**Mateusz Kołtuniuk**

Plik: `UserProxy`

Opis: Wykorzystanie wzorca Proxy umożliwia wstrzyknięcie logiki biznesowej przed wywołaniem oryginalnej metody klas opakowanych. Nieaktywny użytkownik nie może się zalogować.

**Adam Krawczyk**

Plik: `SecuredItemProxy`

Opis: Uprawniony użytkownik (pracownik) ma dostęp do ukrytych danych – ID przedmiotu.

---

### Flyweight

**Zofia Borys**

Plik: `BookMetaFlyweightFactory`

Opis: Zarządza pamięcią podręczną współdzielonych obiektów metadanych książek (`BookMetaFlyweight`), zapewniając, że te same kombinacje autora, tytułu i formatu są przechowywane w tylko jednej instancji. Technika ta, wykorzystywana przez klasę `LoanWithBookFlyweight`, pozwala znacząco ograniczyć zużycie pamięci przy dużej liczbie wypożyczeń tych samych pozycji.

**Mateusz Kołtuniuk**

Plik: `RoleFactory`

Opis: Przechowując instancję każdej roli w mapie, możemy je następnie wstrzykiwać tam, gdzie są potrzebne, zamiast za każdym razem tworzyć nowy obiekt. Ogranicza to zużycie pamięci.

**Adam Krawczyk**

Plik: `FormatFactory`

Opis: Optymalizacja pamięci poprzez stworzenie pojedynczej instancji danego formatu.

---

## Tydzień 5 – Wzorce behawioralne

### Command

**Zofia Borys**

Plik: `StoreCommand`

Opis: Definiuje wspólny interfejs dla wszystkich operacji wykonywanych w systemie, takich jak `LoanBookCommand` (wypożyczenie) czy `ReturnBookCommand` (zwrot), umożliwiając ich parametryzację oraz wywoływanie przez obiekt `StoreCommandInvoker`.

**Mateusz Kołtuniuk**

Plik: `UserCommand`

Opis: Interfejs `UserCommand` wymusza na implementacjach metodę `execute()`. Metoda w zależności od implementacji przeprowadza inną operację. Możemy rozszerzać aplikację o kolejne komendy bez potrzeby zmian poprzednich implementacji.

**Adam Krawczyk**

Plik: `ChangeTitleCommand`

Opis: Zmiana tytułu przedmiotu.

---

### Interpreter

**Zofia Borys**

Plik: `StoreQueryInterpreter`

Opis: Przekształca proste instrukcje tekstowe na obiekty logiczne, umożliwiając filtrowanie książek na podstawie autora (`AuthorExpression`) lub tytułu (`TitleExpression`) poprzez wspólną metodę `interpret`.

**Mateusz Kołtuniuk**

Plik: `ExpressionInterpreter`

Opis: Wzorzec na podstawie instrukcji tekstowej interpretuje, czy i jaki obiekt został zwrócony bądź wypożyczony. Umożliwia to wykorzystanie interfejsu `Expression` z metodą `interpret`. Następnie tworzony jest obiekt implementujący ten interfejs w zależności od instrukcji.

**Adam Krawczyk**

Plik: `ItemExpression`, `AuthorExpression`, `TitleExpression`, `AndExpression`

Opis: Filtrowanie przedmiotów po autorze i tytule.

---

### Iterator

**Zofia Borys**

Plik: `LoanIterator`

Opis: Definiuje interfejs do sekwencyjnego przeglądania kolekcji wypożyczeń, co pozwala na różne sposoby przechodzenia przez dane, np. poprzez standardową listę w `LoanCollection` lub filtrowanie aktywnych pozycji w `ActiveLoanIterator`.

**Mateusz Kołtuniuk**

Plik: `UserCollection`

Opis: Klasa `UserCollection` opakowuje listę userów, a następnie zwraca iterator, który zwraca tylko obiekty klasy `Customer`.

**Adam Krawczyk**

Plik: `ItemCollection`, `ItemIterator`, `ItemCollectionImpl`

Opis: Iterator przechodzi po książkach danego autora.

---

### Mediator

**Zofia Borys**

Plik: `StoreEventMediator`

Opis: Centralizuje komunikację między niezależnymi serwisami (`NotificationService`, `InventoryService`), reagując na zdarzenia systemowe i koordynując ich działania bez konieczności bezpośredniego powiązania tych klas ze sobą.

**Mateusz Kołtuniuk**

Plik: `UserMediatorImpl`

Opis: Opakowuje niezależne serwisy i wywołuje ich metody reagując na zdarzenia systemowe.

**Adam Krawczyk**

Plik: `LibraryMediator`, `LibraryMediatorImpl`

Opis: Komunikacja między niezależnymi serwisami.

---

### Memento

**Zofia Borys**

Plik: `LoanHistory`

Opis: Pełni rolę dozorcy (Caretaker), który zarządza stosem obiektów `LoanMemento`, umożliwiając wycofywanie zmian i przywracanie poprzednich stanów wypożyczeń poprzez klasę `LoanOriginator`.

**Mateusz Kołtuniuk**
Pliki: `CartHistory`, `CartMemento`

Opis: Wykorzystanie wzorca Memento umożliwia wycofywanie zmian i przywracanie poprzednich stanów koszyka. `CartMemento` jest snapshotem koszyka, a `CartHistory` zarządza stosem tych snapshotów.

**Adam Krawczyk**

Plik: `ItemMemento`, `ItemHistory`

Opis: Możliwość cofania zmian.

---

## Tydzień 6 – Wzorce behawioralne (cd.)

### Observer

**Zofia Borys**

Plik: `Store`

Opis: Pełni rolę podmiotu (Subject), który utrzymuje listę obserwatorów i automatycznie powiadamia obiekty takie jak `AuditLogObserver` czy `EmailNotificationObserver` o istotnych zdarzeniach poprzez metodę `notifyObservers`.

**Mateusz Kołtuniuk**

Plik: `UserAuditLogger`

Opis: Pełni rolę loggera. Wstrzykiwany jest jako observer do obiektu usera i reaguje na wszystkie eventy z nim związane.

**Adam Krawczyk**

Plik: `ItemObserver`

Opis: Powiadomienie obserwujących o dostępności przedmiotu.

---

### State

**Zofia Borys**

Plik: `OrderState`

Opis: Definiuje interfejs dla różnych stanów zamówienia, umożliwiając obiektowi `Order` dynamiczną zmianę zachowania i przejść (np. z `NewOrderState` przez `ProcessingOrderState` do `CompletedOrderState`) w zależności od jego aktualnego etapu procesowania.

**Mateusz Kołtuniuk**

Plik: `UserState`

Opis: Definiuje interfejs dla różnych stanów konta użytkownika. Obiekt `User` może dynamicznie zmieniać stan konta – np. aktywny, zbanowany. Stan konta jest reprezentowany przez różne klasy implementujące interfejs `UserState`.

**Adam Krawczyk**

Plik: `ItemState`, `AvailableState`, `BorrowedState`

Opis: Wprowadzenie stanów przedmiotu (wypożyczony, dostępny).

---

### Strategy

**Zofia Borys**

Plik: `DiscountStrategy`

Opis: Definiuje wspólny interfejs dla różnych algorytmów naliczania zniżek, co pozwala klasie `PricingCalculator` na dynamiczną zmianę sposobu obliczania ceny końcowej w zależności od typu klienta (Regular, Student, VIP).

**Mateusz Kołtuniuk**

Plik: `NotificationStrategy`

Opis: Wykorzystując wzorzec Strategy tworzymy wspólny interfejs dla metod powiadamiania użytkownika. Następnie w zależności od wymagań biznesowych wstrzykujemy odpowiednią implementację tego interfejsu.

**Adam Krawczyk**

Plik: `PenaltyStrategy`

Opis: Wprowadzenie różnych kar za opóźnienie w oddaniu zwykłej książki oraz bestsellera.

---

### Template Method

**Zofia Borys**

Plik: `OrderProcessor`

Opis: Definiuje szkielet algorytmu przetwarzania zamówienia w metodzie `processOrder`, delegując specyficzne kroki, takie jak weryfikacja dostępności i pakowanie, do podklas `DigitalOrderProcessor` oraz `PhysicalOrderProcessor`.

**Mateusz Kołtuniuk**

Plik: `UserRegistrationTemplate`

Opis: Definiuje szkielet procesu rejestracji użytkownika. Udostępnia dwie metody abstrakcyjne, które klasy dziedziczące muszą nadpisać. Np. implementacja `CustomerRegistration` nadpisuje metody `createUser()` i `assignRole()`, dzięki czemu tworzy obiekt `Customer` i przyznaje mu odpowiednią rolę.

**Adam Krawczyk**

Plik: `ItemProcessingTemplate`

Opis: Proces dodawania nowych przedmiotów.

---

### Visitor

**Zofia Borys**

Plik: `StoreAuditVisitor`

Opis: Implementuje logikę audytu wariantu Type-Checking Visitor, która pozwala na dodawanie nowych operacji do obiektów klas `PhysicalStore` oraz `OnlineStore` bez konieczności modyfikowania ich struktury wewnętrznej czy wprowadzania metody `accept`.

**Mateusz Kołtuniuk**

Plik: `PermissionAuditVisitor`

Opis: Wykorzystując wzorzec Visitor tworzymy wspólny interfejs do obsługi różnych typów użytkowników. Następnie dla każdej konkretnej klasy użytkownika implementujemy osobną metodę odwiedzającą, która odpowiada za generowanie raportu uprawnień zgodnie z wymaganiami biznesowymi.

**Adam Krawczyk**

Plik: `ItemVisitor`

Opis: Tworzenie raportu o przedmiotach w formacie XML.

---

## Tydzień 7 – Zasady SOLID

### Zasada pojedynczej odpowiedzialności (SRP)

**Zofia Borys**

Plik: `DatabaseConnectionHandler`

Opis: Klasa odpowiada wyłącznie za techniczne aspekty zarządzania sesją i połączeniem z infrastrukturą bazy danych.

**Mateusz Kołtuniuk**

Plik: `DatabaseDataHandler`

Opis: Skupia się wyłącznie na operacjach na danych (DML), zarządzając dodawaniem, aktualizacją i usuwaniem rekordów książek.

**Adam Krawczyk**

Plik: `DatabaseStructureHandler`

Opis: Odpowiada za zarządzanie strukturą bazy danych (DDL), taką jak tworzenie i usuwanie tabel, odseparowując te zadania od logiki danych i połączeń.

---

### Zasada otwarte-zamknięte (OCP)

**Zofia Borys**

Plik: `PenaltyRegistry`

Opis: Realizuje zasadę poprzez podejście Data-Driven, umożliwiając dynamiczne rozszerzanie systemu o nowe strategie kar bez modyfikacji istniejącego kodu źródłowego rejestru.


Plik: `HighPenalty`

Opis: Dodanie nowego rodzaju kary za oddanie przedmiotu po terminie w specjalnych przypadkach.

**Mateusz Kołtuniuk**

Plik: `ItemRegistry`

Opis: Realizuje zasadę poprzez podejście Data-Driven, umożliwiając dynamiczne rozszerzanie systemu o nowe itemy bez modyfikacji istniejącego kodu źródłowego rejestru.


Plik: `DiscountRegistry`

Opis: Realizuje zasadę poprzez podejście Data-Driven, umożliwiając dynamiczne rozszerzanie systemu o nowe strategie zniżek bez modyfikacji istniejącego kodu źródłowego rejestru.

**Adam Krawczyk**

Plik: `CD`

Opis: Dodanie nowego przedmiotu jakim jest płyta CD.


Plik: `CDCreator`

Opis: Stworzenie płyty CD na fabryce.

---

## Tydzień 8 – Zasady SOLID (cd.)

### Zasada podstawienia Liskov (LSP)

**Zofia Borys**

Plik: `User`

Opis: Klasa bazowa definiująca wspólny kontrakt (metody `logIn`, `logOut`, `accept`), który gwarantuje, że podklasy takie jak `Customer` czy `Employee` są w pełni wymienialne i nie naruszają logiki systemu przy zmianie konkretnej implementacji użytkownika.

**Mateusz Kołtuniuk**

Plik: `Item`

Opis: Klasa bazowa definiująca główny kontrakt dla wszystkich zasobów w systemie (metody `describe()` i `getInternalDetails()`). Jej klasy pochodne, takie jak `Book` oraz `CD`, poprawnie implementują ten kontrakt bez wprowadzania błędów, co gwarantuje ich 100-procentową wymienność w logice aplikacji.

**Adam Krawczyk**

Plik: `Store`

Opis: Klasa bazowa definiująca spójny kontrakt dla operacji sklepowych (metoda `processOrder()`). Klasy pochodne, takie jak `OnlineStore` oraz `PhysicalStore`, w pełni respektują ten kontrakt, zachowując oczekiwane zachowania oraz typy zwracane, co gwarantuje pełną, bezpieczną zastępowalność podklas w dowolnym miejscu systemu oczekującym obiektu typu `Store`.

---

### Zasada odwracania zależności (DIP)

**Zofia Borys**

Plik: `OrderNotificationService`

Opis: Klasa wysokopoziomowa, która nie zależy od konkretnych implementacji (takich jak `SmsSender`), lecz od abstrakcji `MessageSender`. Pozwala to na łatwą wymianę kanału komunikacji bez modyfikacji logiki powiadomień.

**Mateusz Kołtuniuk**

Plik: `AuditManager`

Opis: Klasa wysokopoziomowa, która zależy wyłącznie od abstrakcji `ReportGenerator`, a nie od konkretu (`PdfReportGenerator`). Pozwala to na łatwą zmianę formatu raportu bez modyfikacji logiki audytu.

**Adam Krawczyk**

Plik: `InventoryService`

Opis: Klasa wysokopoziomowa realizująca logikę biznesową dostaw, która zależy wyłącznie od abstrakcji `DataStorage`. Dzięki temu system jest całkowicie odcięty od niskopoziomowych szczegółów zapisu danych, takich jak operacje SQL w klasie `SqlDataStorage`.

---

### Zasada segregacji interfejsów (ISP)

**Zofia Borys**

Plik: `CashProcessor`

Opis: Przykład wydzielenia wąskiego, wyspecjalizowanego interfejsu, który ogranicza wymagania wobec klas implementujących wyłącznie do obsługi płatności gotówkowych. Dzięki temu klasy takie jak sklep internetowy nie są zmuszane do implementacji metod, których nie potrzebują.

**Mateusz Kołtuniuk**

Plik: `Borrowable`

Opis: Reprezentuje podział „grubego" interfejsu operacji na zasobach na węższe, wyspecjalizowane kontrakty. Poprzez rozdzielenie zachowań na `Borrowable` (dla fizycznych wypożyczeń) oraz `Downloadable` (dla cyfrowych pobrań), klasy konkretnych przedmiotów implementują tylko te metody, których faktycznie potrzebują.

**Adam Krawczyk**

Plik: `OrderHandler`

Opis: Przykład podziału szerokiego interfejsu administracyjnego na mniejsze role. Rozdzielenie zachowań na `OrderHandler` (obsługa zamówień) oraz `UserModerator` (moderacja użytkowników) gwarantuje, że klasy poszczególnych typów pracowników implementują tylko te funkcje, do których mają uprawnienia.

---

## Tydzień 10 – Programowanie funkcyjne

### Interfejsy funkcyjne

**Zofia Borys**
Pliki: `ItemDescriber`, `FunctionalInterfaceService`

Opis: Interfejs funkcyjny udostępniający metodę `describe()`, która zwraca opis przedmiotu w postaci ciągu znaków.

**Mateusz Kołtuniuk**
Pliki: `ItemPricer`, `FunctionalInterfaceService`

Opis: Interfejs funkcyjny udostępniający metodę `calculatePrice()`, która oblicza cenę końcową przedmiotu.

**Adam Krawczyk**
Pliki: `UserNotifier`, `FunctionalInterfaceService`

Opis: Interfejs funkcyjny udostępniający metodę `notify()`, która wysyła powiadomienie do użytkownika i zwraca potwierdzenie w formie ciągu znaków.

---

### Strumieniowe przetwarzanie kolekcji


Plik: `StreamProcessingService`

Opis: Serwis z metodami przetwarzającymi listy userów, orderów i itemów przy pomocy streamów.

---

### Interfejsy Predicate i Function


Plik: `PredicateFunctionService`

Opis: Serwis z metodami wykorzystującymi wbudowane interfejsy `Predicate` i `Function`.

---

## Tydzień 13 – Testy jednostkowe

**Zofia Borys**


Plik: `StoreFactoryTest`

Opis: Testuje poprawność tworzenia obiektów przez konkretne fabryki (`OnlineStoreCreator`, `PhysicalStoreCreator`) oraz sprawdza, czy fabryka typu Singleton zawsze zwraca tę samą instancję kreatora.


Plik: `StoreInterpreterTest`

Opis: Weryfikuje logikę interpretacji zapytań tekstowych. Testy sprawdzają poprawność działania wyrażeń terminalnych (`AuthorExpression`, `TitleExpression`), działanie parsera dla komend tekstowych oraz odporność systemu na błędy (rzucanie wyjątków przy nieznanych poleceniach).


Plik: `DiscountRegistryTest`

Opis: Testuje mechanizm rejestru zniżek działający zgodnie z zasadą Open-Closed. Weryfikuje, czy system poprawnie aplikuje zdefiniowane upusty, czy pozwala na dynamiczne dodawanie nowych typów zniżek bez modyfikacji kodu źródłowego klasy oraz czy prawidłowo obsługuje sytuacje błędne (nieznane typy zniżek).

---

**Mateusz Kołtuniuk**


Plik: `UserFactoryTest`

Opis: Testuje poprawność tworzenia obiektów przez konkretne fabryki (`EmployeeCreator`, `CustomerCreator`) oraz sprawdza, czy fabryka typu Singleton zawsze zwraca tę samą instancję kreatora.


Plik: `OidcUserAdapterTest`

Opis: Testuje poprawność tworzenia obiektów adaptera dla klasy `OidcUser` oraz poprawność działania metod wywołanych na tym adapterze i ich skutków na obiekt zagnieżdżony.


Plik: `CartMementoTest`

Opis: Testuje mechanizm tworzenia koszyka, snapshotów tego koszyka oraz przywracania stanów koszyka z tych snapshotów.

---

**Adam Krawczyk**


Plik: `EmployerBuilderTest`

Opis: Weryfikuje poprawność działania budowniczego, sprawdzając, czy obiekty są tworzone z właściwymi parametrami oraz czy pola pomocnicze są prawidłowo czyszczone po wywołaniu metod `reset()` i `build()`.


Plik: `PhysicalStoreBuilderTest`

Opis: Weryfikuje poprawność działania budowniczego, sprawdzając, czy obiekty są tworzone z właściwymi parametrami oraz czy pola pomocnicze są prawidłowo czyszczone po wywołaniu metod `reset()` i `build()`.
