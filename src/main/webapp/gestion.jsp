

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestion de stock</title>
   
    
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    
<body class="bg-gray-100 font-sans">

    <div class="container mx-auto p-4">
        <h1 class="text-3xl font-bold text-center mb-6">Liste des produits</h1>

       
        <form id="ajouterProduitForm" action="insert" method="post" class="bg-white p-6 rounded-lg shadow-lg">
            <input type="text" id="nom" name="nom" placeholder="Nom du produit" class="border p-2 rounded mb-4 w-full" required>
            <input type="text" id="description" name="description" placeholder="Description" class="border p-2 rounded mb-4 w-full">
            <input type="number" id="quantite" name="quantite_en_stock" placeholder="Quantite" class="border p-2 rounded mb-4 w-full" required inputmode="numeric">
            <input type="number" id="prix" name="prix" step="2" placeholder="Prix" class="border p-2 rounded mb-4 w-full" required>
            <select id="categorie" name="categorie" class="border p-2 rounded mb-4 w-full">
                <option value="Categorie">Categorie</option>
                <option value="Vêtements">Vetements</option>
                <option value="Alimentation">Alimentation</option>
                </select>
            <button type="submit" class="bg-green-500 text-white p-2 rounded w-full">Ajouter un produit</button>
        </form>

        
        <table id="produitsTable" class="mt-8 w-full bg-white rounded-lg shadow-md">
            <thead>
                <tr class="bg-gray-200">
                <th class="px-4 py-2">Id</th>
                    <th class="px-4 py-2">Nom</th>
                    <th class="px-4 py-2">Description</th>
                    <th class="px-4 py-2">Quantite</th>
                    <th class="px-4 py-2">Prix</th>
                    <th class="px-4 py-2">Categorie</th>
                </tr>
            </thead>
            <tbody>
               <c:forEach var="produit" items="${listProduit}">
                    <tr class="px-4 py-2 mx-4"  >
                        <td class="px-4 py-2 "><c:out value="${produit.id}" /></td>
                        <td class="px-4 py-2"><c:out value="${produit.nom}" /></td>
                        <td class="px-4 py-2"><c:out value="${produit.description}" /></td>
                        <td class="px-4 py-2"><c:out value="${produit.quantite}" /></td>
                        <td class="px-4 py-2"><c:out value="${produit.prix}" /></td>
                        <td class="px-4 py-2"><c:out value="${produit.categorie}" /></td>
                        </tr>
                        </c:forEach>
            </tbody>
        </table>
    </div>

   
   
</body>

</html>
