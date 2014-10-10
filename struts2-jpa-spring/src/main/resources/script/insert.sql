--Utilisateur 1 :
INSERT INTO ut_utilisateur( version,id , email, firstname, lastname, leavingdatetime, creatingdatetime, login,password,enabled) VALUES (0, nextval('ut_utilisateur_sequence'),'j@v.com','nom','prenom',LOCALTIMESTAMP,LOCALTIMESTAMP,'rod','koala',true);
INSERT INTO pa_role( version, id, intitule) VALUES (0,nextval('ut_role_sequence'), 'user');
INSERT INTO inpa_role_utilisateur( utilisateur_id,role_id) VALUES (currval('ut_utilisateur_sequence'),currval('ut_role_sequence'));
--Utilisateur 2 :
INSERT INTO ut_utilisateur( version,id , email, firstname, lastname, leavingdatetime, creatingdatetime, login,password,enabled) VALUES (0, nextval('ut_utilisateur_sequence'),'j2@v.com','nom2','prenom2',LOCALTIMESTAMP,LOCALTIMESTAMP,'admin','koala',true);
INSERT INTO pa_role( version, id, intitule) VALUES (0,nextval('ut_role_sequence'), 'admin');
INSERT INTO inpa_role_utilisateur( utilisateur_id,role_id) VALUES (currval('ut_utilisateur_sequence'),currval('ut_role_sequence'));
--INSERT INTO pa_parcours( version, id, intitule, utilisateur_id) VALUES (0,nextval('pa_parcours_sequence'), 'parcours_test', currval('ut_utilisateur_sequence'));
--INSERT INTO pa_parcours( version, id, intitule, utilisateur_id) VALUES (0,nextval('pa_parcours_sequence'), 'parcours_test', currval('ut_utilisateur_sequence'));

