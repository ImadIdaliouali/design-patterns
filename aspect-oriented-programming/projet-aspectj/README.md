# Projet AspectJ - Application Bancaire

## Description
Application console de gestion bancaire démontrant l'AOP avec **AspectJ** et le **tissage à la compilation** (compile-time weaving).

## Architecture

### Couche Métier
- **`Compte`** : Entité représentant un compte bancaire (code, solde)
- **`IMetierBanque`** : Interface définissant les opérations bancaires
- **`MetierBanqueImpl`** : Implémentation avec **faille intentionnelle** dans `retirer()` (autorise les soldes négatifs)

### Aspects (Syntaxe @Aspect)
1. **`LogAspect`** : Journalisation avec calcul de durée d'exécution (@Around)
2. **`PatchRetraitAspect`** : Correction de la faille sans modifier le code source (vérifie le solde avant retrait)
3. **`SecurityAspect`** : Authentification au démarrage (root/1234)

## Point de Tissage (Weaving)
Le tissage se fait à la **COMPILATION** via le plugin `aspectj-maven-plugin` qui utilise le compilateur **ajc** au lieu de javac. Les aspects sont intégrés directement dans le bytecode des classes métier.

## Compilation et Exécution

### Compilation
```powershell
mvn clean compile
```
Le compilateur ajc tisse les aspects dans les classes métier.

### Exécution
```powershell
mvn exec:java -Dexec.mainClass="ma.enset.banking.Application"
```

### Tests Fonctionnels
1. **Authentification** : Entrer `root` / `1234` pour démarrer l'application
2. **Créer un compte** : Saisir code et solde initial
3. **Tester le patch** : Tenter un retrait supérieur au solde → Exception "Solde insuffisant"
4. **Observer les logs** : Chaque opération affiche la durée d'exécution

## Dépendances Maven
- `aspectjrt` : Runtime AspectJ
- `aspectj-maven-plugin` : Compilateur ajc pour le tissage
