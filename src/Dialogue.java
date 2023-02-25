import java.util.Scanner;


public class Dialogue {
    public void start(Scanner in, Hero hero){   //Méthode du lancement du jeu : Cette méthode fonctionne 
        boolean choiceReady = false;
        while (!choiceReady){
            boolean validInput;
            do {
                System.out.println("--------------------------------------------------------------------\n"+ 
                "Salut à toi nouveau joueur ! Es-tu prêt pour une nouvelle aventure ?\n"+ 
                "1 : Oui\n"+ 
                "2 : Non\n"+ 
                "--------------------------------------------------------------------\n");
                int ready = in.nextInt();
                validInput = true;
                switch (ready){
                    case 1 :
                        choiceReady = true;
                        Scanner in1 = new Scanner (System.in); 
                        System.out.println("--------------------------------------------------------------------\n"+
                            "Bravo à toi, tu as fait le bon choix !\n"+
                            "Avant de commencer, j'aurais besoin de ton nom, comment t'appelles tu joueur ?\n"+
                            "--------------------------------------------------------------------\n");
                        String name = in1.next();
                        in1.close();
                        hero.set_name(name);
                        System.out.println("--------------------------------------------------------------------\n"+
                            "Bien, merci "+ hero.get_name() + " maintenant laisse moi t'expliquer les règles : \n"+
                            "Toi, tu es le Héro qui va devoir te promener sur une map,\n"+ 
                            "sur ton chemin, tu vas rencontrer toute sorte de passants, de simple ennemies, des monstres et pour finir, un boss final.\n" +
                            "Pour t'aider à survivre, tu auras à ta disposition plusieurs objets, des armes, des potions, des artefacts.\n"+
                            " Ces objets pourront te permettre de mener à bien ta mission, je te rappellerai en temps voulu l'utilité de chaque objet.\n"+
                            "Ta mission donc, le but du jeu, est de vaincre le boss final ! Pour ça, tu auras besoin d'être stratège et ingénieux !\n"+
                            "Je ne t'en dis pas plus, mais sache que je serai toujours là pour t'aider dans ta quête.\n" +
                            "Bien, il est grand temps pour toi de te lancer dans l'aventure, bonne chance à toi "+ hero.get_name() +" !\n"+
                            "--------------------------------------------------------------------");
                        System.out.println("    "); 
                    break;

                    case 2 : 
                        choiceReady = false;                    
                    break;

                    default:   
                        System.out.println("Je n'est pas compris.");
                        validInput = false; 
                }
            } while (!validInput);
        }
    }
    
    public void player_choice(Scanner in, Hero hero){   //Savoir quel action le joueur veut effectuer, se déplacer, consulter son inventaire
        boolean choice = false;
        while(!choice){
            boolean validInput;
            do{
                System.out.println("Quel action veut tu effectuer?\n"+
                "1 : Me déplacer\n"+
                "2 : Consulter mon inventaire\n");
                int variable_in = in.nextInt();
                validInput = true;
                switch(variable_in){
                    case 1:
                        choice = true;
                        this.player_move(in, hero);
                    break;

                    case 2:
                        choice = true;
                        hero.bag_view();
                    break;
                    
                    default:  
                        System.out.println("Je n'est pas compris.");
                        validInput = false;
                    break;
                }
            }while (!validInput);
        }
    }   
    public void player_move(Scanner in, Hero hero){    //Faire bouger le joueur : Cette méthode fonctionne
        boolean choiceMove = false;
        while(!choiceMove){
            boolean validInput;
            do{
                System.out.println("Dans quel direction voulez-vous aller ?\n"+ 
                    "1: En Haut\n"+ 
                    "2: En Bas\n"+ 
                    "3: A Gauche\n"+ 
                    "4: A droite"
                );
                int move = in.nextInt();
                validInput = true;
                switch(move){
                    case 1: 
                        hero.turn_up();
                        choiceMove = true;
                    break;
                    case 2: 
                        hero.turn_down();
                        choiceMove = true;
                    break;
                    case 3: 
                        hero.turn_left(); 
                        choiceMove = true;
                    break;
                    case 4: 
                        hero.turn_right(); 
                        choiceMove = true;
                    break;
                    default : 
                        System.out.println("Je n'ai pas compris votre demande.");
                        validInput = false; 
                }
            } while(!validInput);
        } 
    }
    
    public void cross_chest(Scanner in, Hero hero, Chest chest){    //Quand on croise un coffre
        boolean choice= false;
        while(!choice){
            boolean validInput;
            do{
                System.out.println("Vous vous trouvez devant un coffre, que voulez vous faire ?\n"+ 
                "1 : Ouvrir le coffre\n"+ 
                "2 : Passer mon chemin\n"
                );
                int variable_in = in.nextInt();
                validInput = true;
                switch(variable_in){
                    case 1: 
                        hero.turn_up();
                        choice = true;
                        chest.view_content();
                        System.out.println("Voulez vous prendre l'objet ?\n"+ 
                        "1 : Oui\n"+ 
                        "2 : Non\n"
                        );
                        int variable_in2 = in.nextInt();
                        switch(variable_in2){
                            case 1 : 
                                hero.take_object(chest.get_content(), chest);
                            break;
                            case 2 :
                                choice = true;
                            break;

                            default : 
                                System.out.println("Je n'ai pas compris votre demande.");
                                validInput = false; 
                            break;  
                        }
                    break;

                    case 2: 
                        choice = true;
                    break;

                    default : 
                        System.out.println("Je n'ai pas compris votre demande.");
                        validInput = false; 
                    break;
                }
            } while(!validInput);
        }
    }
    public void cross_enemy(){
        System.out.println("--------------------------------------------------------------------\n"+
            "Oh, il semblerait que tu sois face à un ennemi, un combat va se lancer, sois prêt !\n"+
            "--------------------------------------------------------------------");
    }
    
    public void file_object(Scanner in, Hero hero, Chest chest){
        boolean choiceObject = false;
        while(!choiceObject){
            boolean validInput;
            do{
                System.out.println("Que voulez-vous déposer ?\n"+
                    "1 : Une Arme\n"+
                    "2 : Un Artefact\n"+
                    "3 : Une Potion\n"+
                    "4 : Quitter"
                );
                int choice = in.nextInt();
                validInput = true;
                Scanner in1 = new Scanner (System.in);
                int element;
                switch(choice){
                    case 1:
                        hero.weapon_bag_view();
                        System.out.println("Quel élément voulez-vous déposer ?\n"+
                        "1 : Elément 1\n"+
                        "2 : Element 2\n");
                        element = in1.nextInt();
                        switch(element){
                            case 1 :
                                if(hero.weapon_bag.size() >= 1) hero.file_object(hero.weapon_bag.get(0), chest);
                                else System.out.println("Vous ne pouvez pas déposer cet élément.");
                            break;

                            case 2 :
                                if(hero.weapon_bag.size() == 2) hero.file_object(hero.weapon_bag.get(1), chest);
                                else System.out.println("Vous ne pouvez pas déposer cet élément.");
                            break;
                            default :
                                System.out.println("Je n'ai pas compris votre demande.");
                                validInput = false; 
                            break;
                        }
                        choiceObject = true;
                    break;
                    case 2:
                        hero.actefact_bag_view();
                        System.out.println("Quel élément voulez-vous déposer ?\n"+
                        "1 : Elément 1\n"+
                        "2 : Element 2\n"+
                        "3 : Element 3\n");
                        element = in1.nextInt();
                        switch(element){
                            case 1 : 
                                if(hero.actefact_bag.size() >= 1) hero.file_object(hero.actefact_bag.get(0), chest);
                                else System.out.println("Vous ne pouvez pas déposer cet élément.");
                            break;
                            case 2 : 
                                if(hero.actefact_bag.size() >= 2) hero.file_object(hero.actefact_bag.get(1), chest);
                                else System.out.println("Vous ne pouvez pas déposer cet élément.");
                            break;
                            case 3 : 
                                if(hero.actefact_bag.size() == 3) hero.file_object(hero.actefact_bag.get(2), chest);
                                else System.out.println("Vous ne pouvez pas déposer cet élément.");
                            break;
                            default :
                                System.out.println("Je n'ai pas compris votre demande.");
                                validInput = false; 
                            break;
                        }
                        choiceObject = true;
                    break;
                    case 3:
                        hero.potion_bag_view();
                        System.out.println("Quel élément voulez-vous déposer ?\n"+
                        "1 : Elément 1\n"+
                        "2 : Element 2\n"+
                        "3 : Element 3\n"+
                        "4 : Element 4\n"+
                        "5 : Element 5\n");
                        element = in1.nextInt();
                        switch(element){
                            case 1 : 
                                if(hero.potion_bag.size() >= 1) hero.file_object(hero.actefact_bag.get(0), chest);
                                else System.out.println("Vous ne pouvez pas déposer cet élément.");
                            break;
                            case 2 : 
                                if(hero.potion_bag.size() >= 2) hero.file_object(hero.actefact_bag.get(1), chest);
                                else System.out.println("Vous ne pouvez pas déposer cet élément.");
                            break;
                            case 3 : 
                                if(hero.potion_bag.size() >= 3) hero.file_object(hero.actefact_bag.get(2), chest);
                                else System.out.println("Vous ne pouvez pas déposer cet élément.");
                            break;
                            case 4 : 
                                if(hero.potion_bag.size() >= 4) hero.file_object(hero.actefact_bag.get(3), chest);
                                else System.out.println("Vous ne pouvez pas déposer cet élément.");
                            break;
                            case 5 : 
                                if(hero.potion_bag.size() == 5) hero.file_object(hero.actefact_bag.get(4), chest);
                                else System.out.println("Vous ne pouvez pas déposer cet élément.");
                            break;
                            default :
                                System.out.println("Je n'ai pas compris votre demande.");
                                validInput = false; 
                            break;
                        } 
                        choiceObject = true;
                    break; 
                    case 4:
                        choiceObject = true;
                    break;
                    default : 
                        System.out.println("Je n'ai pas compris votre demande.");
                        validInput = false; 
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
                System.out.println("--------------------------------------------------------------------\n"+ 
                "Quel élément voulez-vous prendre ?\n"+
                "1 : Elément 1\n"+
                "2 : Element 2\n"+
                "--------------------------------------------------------------------\n"); 
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
                        System.out.println("Je n'est pas compris.");
                        validInput = false; 
                    break;
                }
            } while (!validInput);
        }
    }
    
    public void finish(Scanner in, Hero hero, Map map){
        boolean choice = false;
        while(!choice){
            boolean validInput;
            do{
                System.out.println("La partie est terminée\n"+
                "1 : Relancer une partie\n"+
                "2 : Quitter");
                int variable_in = in.nextInt();
                validInput = true;
                switch(variable_in){
                    case 1:
                        choice = true;
                        /*Game game = new Game(hero, map);
                        game.start(hero, map, inout, in);*/
                    break;

                    case 2:
                        choice = false;
                    break;

                    default:  
                        System.out.println("Je n'est pas compris.");
                        validInput = false;
                    break;
                }
            }while (!validInput);
        }      
    }
}