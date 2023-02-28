import java.util.Scanner;

public class Dialogue {
/*###########################################-METHODES-################################################################################################*/

    public void start(Scanner in, Hero hero){   //Méthode du lancement du jeu 
        boolean choiceReady = false;
        while (!choiceReady){
            boolean validInput;
            do {
                System.out.println(); 
                System.out.println("--------------------------------------------------------------------\n"+ 
                "Salut à toi nouveau joueur ! Es-tu prêt pour une nouvelle aventure ?\n"+ 
                "1 : Oui\n"+ 
                "2 : Non\n"+ 
                "--------------------------------------------------------------------\n");
                System.out.println(); 
                int ready = in.nextInt();
                validInput = true;
                switch (ready){
                    case 1 :
                        choiceReady = true;
                        System.out.println(); 
                        System.out.println("--------------------------------------------------------------------\n"+
                        "Bravo à toi, tu as fait le bon choix !\n"+
                        "Avant de commencer, j'aurais besoin de ton nom, comment t'appelles tu joueur ?\n"+
                        "--------------------------------------------------------------------\n");
                        System.out.println(); 

                        String name = in.next();
                        hero.set_name(name);
                        System.out.println(); 
                        System.out.println("--------------------------------------------------------------------\n"+
                        "Bien, merci "+ hero.get_name() + " maintenant laisse moi t'expliquer les règles : \n"+
                        "Toi, tu es le Héro qui va devoir te promener sur une map,\n"+ 
                        "sur ton chemin, tu vas rencontrer des ennemies et pour finir, un boss final.\n" +
                        "Pour t'aider à survivre, tu auras à ta disposition plusieurs objets, des armes, des potions, des artefacts.\n"+
                        "Ces objets pourront te permettre de mener à bien ta mission.\n"+
                        "Ta mission donc est de vaincre le boss final ! Pour ça, tu auras besoin d'être stratège et ingénieux !\n"+
                        "Je ne t'en dis pas plus, mais sache que je serai toujours là pour t'aider dans ta quête.\n" +
                        "Bien, il est grand temps pour toi de te lancer dans l'aventure, bonne chance à toi "+ hero.get_name() +" !\n"+
                        "--------------------------------------------------------------------");
                        System.out.println(); 
                    break;

                    case 2 : 
                        choiceReady = true;
                    break;

                    default:
                        System.out.println(); 
                        System.out.println("--------------------------------------------------------------------\n"+
                        "Je n'ai pas compris votre demande.\n"+
                        "--------------------------------------------------------------------");
                        System.out.println(); 
                        validInput = false;
                    break;
                }
            } while (!validInput);
        }
    }
    
    public void player_choice(Scanner in, Hero hero, Game game){   //Savoir quel action le joueur veut effectuer, se déplacer, consulter son inventaire
        boolean choice = false;
        while(!choice){
            boolean validInput;
            do{
                System.out.println(); 
                System.out.println("--------------------------------------------------------------------\n"+ 
                "Quel action voulez-vous effectuer?\n"+
                "1 : Me déplacer\n"+
                "2 : Consulter mon inventaire\n"+
                "--------------------------------------------------------------------\n");
                System.out.println(); 
                int variable_in = in.nextInt();
                validInput = true;
                switch(variable_in){
                    case 1:
                        choice = true;
                        game.player_move(in, hero);
                    break;

                    case 2:
                        choice = true;
                        hero.bag_view();
                    break;
                    
                    default:  
                        System.out.println(); 
                        System.out.println("--------------------------------------------------------------------\n"+
                        "Je n'ai pas compris votre demande.\n"+
                        "--------------------------------------------------------------------");
                        System.out.println();
                        validInput = false;
                    break;
                }
            }while (!validInput);
        }
    }   
     
    public void cross_chest(Scanner in, Hero hero, Chest chest){    //Quand on croise un coffre
        boolean choice= false;
        while(!choice){
            boolean validInput;
            do{
                System.out.println(); 
                System.out.println("--------------------------------------------------------------------\n"+ 
                "Vous vous trouvez devant un coffre, que voulez vous faire ?\n"+ 
                "1 : Ouvrir le coffre\n"+ 
                "2 : Passer mon chemin\n"+
                "--------------------------------------------------------------------\n");
                System.out.println(); 
                int variable_in = in.nextInt();
                validInput = true;
                switch(variable_in){
                    case 1: 
                        hero.turn_up();
                        choice = true;
                        chest.view_content();
                        System.out.println("--------------------------------------------------------------------\n"+ 
                        "Voulez vous prendre l'objet ?\n"+ 
                        "1 : Oui\n"+ 
                        "2 : Non\n"+
                        "--------------------------------------------------------------------\n");
                        System.out.println(); 
                        int variable_in2 = in.nextInt();
                        switch(variable_in2){
                            case 1 : 
                                hero.take_object(chest.get_content(), chest);
                            break;

                            case 2 :
                                choice = true;
                            break;

                            default:  
                            System.out.println(); 
                            System.out.println("--------------------------------------------------------------------\n"+
                            "Je n'ai pas compris votre demande.\n"+
                            "--------------------------------------------------------------------");
                            System.out.println();
                            validInput = false;
                            break;
                        }
                    break;

                    case 2: 
                        choice = true;
                    break;

                    default:  
                        System.out.println(); 
                        System.out.println("--------------------------------------------------------------------\n"+
                        "Je n'ai pas compris votre demande.\n"+
                        "--------------------------------------------------------------------");
                        System.out.println();
                        validInput = false;
                    break;
                }
            } while(!validInput);
        }
    }
    public void cross_enemy(Character enemy){
        System.out.println(); 
        System.out.println("--------------------------------------------------------------------\n"+ 
        "Oh, il semblerait que tu sois face à un ennemi, son nom est : "+ enemy.get_name()+"\n"+
        "--------------------------------------------------------------------\n");
    }
    
    public void file_object(Scanner in, Hero hero, Chest chest){
        boolean choiceObject = false;
        while(!choiceObject){
            boolean validInput;
            do{
                System.out.println(); 
                System.out.println("--------------------------------------------------------------------\n"+ 
                "Que voulez-vous déposer ?\n"+
                "1 : Une Arme\n"+
                "2 : Un Artefact\n"+
                "3 : Une Potion\n"+
                "4 : Quitter\n"+
                "--------------------------------------------------------------------\n");
                System.out.println(); 
                int choice = in.nextInt();
                validInput = true;
                Scanner in1 = new Scanner (System.in);
                int element;
                switch(choice){
                    case 1:
                        hero.weapon_bag_view();
                        System.out.println(); 
                        System.out.println("--------------------------------------------------------------------\n"+ 
                        "Quel élément voulez-vous déposer ?\n"+
                        "1 : Elément 1\n"+
                        "2 : Element 2\n"+
                        "--------------------------------------------------------------------\n");
                        System.out.println(); 
                        element = in1.nextInt();
                        switch(element){
                            case 1 :
                                if(hero.weapon_bag.size() >= 1) hero.file_object(hero.weapon_bag.get(0), chest);
                                else{
                                    System.out.println(); 
                                    System.out.println("--------------------------------------------------------------------\n"+ 
                                    "Vous ne pouvez pas déposer cet élément.\n"+
                                    "--------------------------------------------------------------------\n");
                                    System.out.println(); 
                                }                            
                            break;

                            case 2 :
                                if(hero.weapon_bag.size() == 2) hero.file_object(hero.weapon_bag.get(1), chest);
                                else{
                                    System.out.println(); 
                                    System.out.println("--------------------------------------------------------------------\n"+ 
                                    "Vous ne pouvez pas déposer cet élément.\n"+
                                    "--------------------------------------------------------------------\n");
                                    System.out.println(); 
                                }                            
                            break;

                            default:  
                                System.out.println(); 
                                System.out.println("--------------------------------------------------------------------\n"+
                                "Je n'ai pas compris votre demande.\n"+
                                "--------------------------------------------------------------------");
                                System.out.println();
                                validInput = false;
                            break;
                        }
                        choiceObject = true;
                    break;
                    case 2:
                        hero.actefact_bag_view();
                        System.out.println(); 
                        System.out.println("--------------------------------------------------------------------\n"+ 
                        "Quel élément voulez-vous déposer ?\n"+
                        "1 : Elément 1\n"+
                        "2 : Element 2\n"+
                        "3 : Element 3\n"+
                        "--------------------------------------------------------------------\n");
                        System.out.println(); 
                        element = in1.nextInt();
                        switch(element){
                            case 1 : 
                                if(hero.actefact_bag.size() >= 1) hero.file_object(hero.actefact_bag.get(0), chest);
                                else{
                                    System.out.println(); 
                                    System.out.println("--------------------------------------------------------------------\n"+ 
                                    "Vous ne pouvez pas déposer cet élément.\n"+
                                    "--------------------------------------------------------------------\n");
                                    System.out.println(); 
                                }                            
                            break;

                            case 2 : 
                                if(hero.actefact_bag.size() >= 2) hero.file_object(hero.actefact_bag.get(1), chest);
                                else{
                                    System.out.println(); 
                                    System.out.println("--------------------------------------------------------------------\n"+ 
                                    "Vous ne pouvez pas déposer cet élément.\n"+
                                    "--------------------------------------------------------------------\n");
                                    System.out.println(); 
                                }                            
                            break;

                            case 3 : 
                                if(hero.actefact_bag.size() == 3) hero.file_object(hero.actefact_bag.get(2), chest);
                                else{
                                    System.out.println(); 
                                    System.out.println("--------------------------------------------------------------------\n"+ 
                                    "Vous ne pouvez pas déposer cet élément.\n"+
                                    "--------------------------------------------------------------------\n");
                                    System.out.println(); 
                                }                            
                            break;

                            default:  
                                System.out.println(); 
                                System.out.println("--------------------------------------------------------------------\n"+
                                "Je n'ai pas compris votre demande.\n"+
                                "--------------------------------------------------------------------");
                                System.out.println();
                                validInput = false;
                            break;
                        }
                        choiceObject = true;
                    break;
                    case 3:
                        hero.potion_bag_view();
                        System.out.println(); 
                        System.out.println("--------------------------------------------------------------------\n"+ 
                        "Quel élément voulez-vous déposer ?\n"+
                        "1 : Elément 1\n"+
                        "2 : Element 2\n"+
                        "3 : Element 3\n"+
                        "4 : Element 4\n"+
                        "5 : Element 5\n"+
                        "--------------------------------------------------------------------\n");
                        System.out.println(); 
                        element = in1.nextInt();
                        switch(element){
                            case 1 : 
                                if(hero.potion_bag.size() >= 1) hero.file_object(hero.potion_bag.get(0), chest);
                                else{
                                    System.out.println(); 
                                    System.out.println("--------------------------------------------------------------------\n"+ 
                                    "Vous ne pouvez pas déposer cet élément.\n"+
                                    "--------------------------------------------------------------------\n");
                                    System.out.println(); 
                                }                            
                            break;

                            case 2 : 
                                if(hero.potion_bag.size() >= 2) hero.file_object(hero.potion_bag.get(1), chest);
                                else{
                                    System.out.println(); 
                                    System.out.println("--------------------------------------------------------------------\n"+ 
                                    "Vous ne pouvez pas déposer cet élément.\n"+
                                    "--------------------------------------------------------------------\n");
                                    System.out.println(); 
                                }                           
                            break;
                            
                            case 3 : 
                                if(hero.potion_bag.size() >= 3) hero.file_object(hero.potion_bag.get(2), chest);
                                else{
                                    System.out.println(); 
                                    System.out.println("--------------------------------------------------------------------\n"+ 
                                    "Vous ne pouvez pas déposer cet élément.\n"+
                                    "--------------------------------------------------------------------\n");
                                    System.out.println(); 
                                }                            
                            break;

                            case 4 : 
                                if(hero.potion_bag.size() >= 4) hero.file_object(hero.potion_bag.get(3), chest);
                                else{
                                    System.out.println(); 
                                    System.out.println("--------------------------------------------------------------------\n"+ 
                                    "Vous ne pouvez pas déposer cet élément.\n"+
                                    "--------------------------------------------------------------------\n");
                                    System.out.println(); 
                                }                            
                            break;

                            case 5 : 
                                if(hero.potion_bag.size() == 5) hero.file_object(hero.potion_bag.get(4), chest);
                                else{
                                    System.out.println(); 
                                    System.out.println("--------------------------------------------------------------------\n"+ 
                                    "Vous ne pouvez pas déposer cet élément.\n"+
                                    "--------------------------------------------------------------------\n");
                                    System.out.println(); 
                                }                           
                            break;

                            default:  
                                System.out.println(); 
                                System.out.println("--------------------------------------------------------------------\n"+
                                "Je n'ai pas compris votre demande.\n"+
                                "--------------------------------------------------------------------");
                                System.out.println();
                                validInput = false;
                            break;
                        } 
                        choiceObject = true;
                    break; 
                    case 4:
                        choiceObject = true;
                    break;
                    default:  
                        System.out.println(); 
                        System.out.println("--------------------------------------------------------------------\n"+
                        "Je n'ai pas compris votre demande.\n"+
                        "--------------------------------------------------------------------");
                        System.out.println();
                        validInput = false;
                    break;
                }
                in1.close();
            }while(!validInput);
        }       
    }
    public void take_weapon(Scanner in, Hero hero){
        boolean choiceWeapon = false;
        while (!choiceWeapon){
            boolean validInput;
            do {
                hero.weapon_bag_view();
                System.out.println();
                System.out.println("--------------------------------------------------------------------\n"+ 
                "Quel élément voulez-vous prendre ?\n"+
                "1 : Elément 1\n"+
                "2 : Element 2\n"+
                "--------------------------------------------------------------------\n"); 
                System.out.println();
                int weapon = in.nextInt();
                validInput = true; 
                switch(weapon){
                    case 1:
                        choiceWeapon = true;
                        hero.take_weapon(hero.weapon_bag.get(0));
                    break;
                    case 2:
                        choiceWeapon = true;
                        hero.take_weapon(hero.weapon_bag.get(1));
                    break;
                    default:  
                        System.out.println(); 
                        System.out.println("--------------------------------------------------------------------\n"+
                        "Je n'ai pas compris votre demande.\n"+
                        "--------------------------------------------------------------------");
                        System.out.println();
                        validInput = false;
                    break;
                }
            } while (!validInput);
        }
    }
    
    public void finish(){
        System.out.println(); 
        System.out.println("--------------------------------------------------------------------\n"+ 
        "La partie est terminée\n"+
        "--------------------------------------------------------------------\n");
        System.out.println(); 
    }        
}