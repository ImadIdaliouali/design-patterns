# Projet Spring AOP - Application de Services

## Description
Application modulaire démontrant l'AOP avec **Spring AOP** et le **tissage dynamique par proxy** (runtime weaving).

## Architecture

### Couche Métier
- **`IMetier`** : Interface de service (process, compute)
- **`MetierImpl`** : Implémentation annotée `@Service` avec méthodes annotées `@Log` et `@SecuredByAspect`

### Annotations Personnalisées
- **`@Log`** : Active la journalisation sur une méthode
- **`@SecuredByAspect`** : Sécurise une méthode par rôles (ex: `roles = {"ADMIN"}`)

### Sécurité
- **`SecurityContext`** : Contexte statique pour authentification et vérification des rôles

### Aspects Spring
1. **`LogAspect`** : Intercepte les méthodes annotées `@Log` (@Around)
2. **`AuthorizationAspect`** : Vérifie les rôles requis via `@SecuredByAspect` (@Around)

### Configuration
- **`AppConfig`** : Configuration Spring avec `@EnableAspectJAutoProxy` (active le tissage par proxy)
- **`App`** : Application principale avec 3 scénarios de test

## Point de Tissage (Weaving)
Le tissage se fait au **RUNTIME** via la création de **proxies dynamiques** par Spring. L'annotation `@EnableAspectJAutoProxy` active ce mécanisme. Spring crée des proxies JDK ou CGLIB qui encapsulent les beans et appliquent les aspects de manière transparente.

## Compilation et Exécution

### Compilation
```powershell
mvn clean compile
```
Utilise le compilateur Java standard (javac), pas ajc.

### Exécution
```powershell
mvn exec:java -Dexec.mainClass="ma.enset.App"
```

### Scénarios de Test
L'application teste automatiquement 3 scénarios :
1. **Utilisateur USER** : Accès à `process()` ✓, refus pour `compute()` ✗
2. **Utilisateur ADMIN** : Accès à toutes les méthodes ✓
3. **Utilisateur GUEST** : Refus pour toutes les méthodes ✗

## Dépendances Maven
- `spring-context` : Conteneur IoC Spring
- `spring-aop` : Support AOP de Spring
- `aspectjweaver` : Weaver AspectJ pour Spring AOP (runtime)
